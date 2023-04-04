package edu.pucmm.eict.alumniratio;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import edu.pucmm.eict.alumniratio.balance.TrialBalance;
import edu.pucmm.eict.alumniratio.balance.TrialBalanceEntry;
import edu.pucmm.eict.alumniratio.configuration.PluginsConfiguration;
import edu.pucmm.eict.alumniratio.exercises.ExerciseController;
import edu.pucmm.eict.alumniratio.exercises.SolvedExercise;
import edu.pucmm.eict.alumniratio.exercises.SolvedExerciseRepository;
import edu.pucmm.eict.alumniratio.journals.general.GeneralJournal;
import edu.pucmm.eict.alumniratio.journals.ledger.GeneralLedger;
import edu.pucmm.eict.alumniratio.reports.exceptions.PDFGenerationErrorException;
import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class AlumniRatioApplication {
    public static void main(String[] args) {
        int appPort = Integer.parseInt(System.getenv("APP_PORT"));
        String uri = System.getenv("MONGODB_URL");
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);

        var generalLedgerClassModel = ClassModel.builder(GeneralLedger.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                .build();

        var generalJournalClassModel = ClassModel.builder(GeneralJournal.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                .build();

        var solvedExerciseClassModel = ClassModel.builder(SolvedExercise.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION, Conventions.OBJECT_ID_GENERATORS))
                .build();

        var trialBalanceClassModel = ClassModel.builder(TrialBalance.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION, Conventions.OBJECT_ID_GENERATORS))
                .build();

        var trialBalanceEntryClassModel = ClassModel.builder(TrialBalanceEntry.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION, Conventions.OBJECT_ID_GENERATORS))
                .build();

        var pojoCodecProvider = PojoCodecProvider.builder()
                .register("edu.pucmm.eict.alumniratio.exercises", "edu.pucmm.eict.alumniratio.transactions", "edu.pucmm.eict.alumniratio.journals.ledger", "edu.pucmm.eict.alumniratio.journals.general", "edu.pucmm.eict.alumniratio.journals.balance")
                .register(generalLedgerClassModel, generalJournalClassModel, solvedExerciseClassModel, trialBalanceClassModel, trialBalanceEntryClassModel)
                .conventions(Conventions.DEFAULT_CONVENTIONS)
                .build();



        var pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        var solvedExerciseRepository = new SolvedExerciseRepository(mongoClient, pojoCodecRegistry);

        var app = Javalin.create(configuration -> {
            configuration.plugins.register(PluginsConfiguration.openApiPluginConfiguration());
            configuration.plugins.register(PluginsConfiguration.swaggerConfiguration());
            configuration.jsonMapper(PluginsConfiguration.jsonMapper());
            configuration.plugins.enableCors(corsContainer -> corsContainer.add(CorsPluginConfig::anyHost));
        });

        var exerciseController = new ExerciseController(solvedExerciseRepository);
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.get("/solved-exercise/{solvedExerciseId}", exerciseController::getSolvedExerciseById);
        app.get("/solved-exercise/{solvedExerciseId}/pdf", exerciseController::getExercisePdf);
        app.exception(PDFGenerationErrorException.class, exerciseController::handlePdfGenerationErrorException);
        app.start(appPort);
    }
}
