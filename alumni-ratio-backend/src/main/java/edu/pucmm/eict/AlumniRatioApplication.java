package edu.pucmm.eict;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import edu.pucmm.eict.configuration.PluginsConfiguration;
import edu.pucmm.eict.exercises.ExerciseController;
import edu.pucmm.eict.exercises.SolvedExercise;
import edu.pucmm.eict.exercises.SolvedExerciseRepository;
import edu.pucmm.eict.journals.general.GeneralJournal;
import edu.pucmm.eict.journals.ledger.GeneralLedger;
import edu.pucmm.eict.reports.exceptions.PDFGenerationErrorException;
import io.javalin.Javalin;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.Convention;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class AlumniRatioApplication {
    public static void main(String[] args) {

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
                conventions(List.of(Conventions.ANNOTATION_CONVENTION)).build();
        var generalJournalClassModel = ClassModel.builder(GeneralJournal.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION)).build();
        var solvedExerciseClassModel = ClassModel.builder(SolvedExercise.class).
                conventions(List.of(Conventions.ANNOTATION_CONVENTION, Conventions.OBJECT_ID_GENERATORS)).build();
        var pojoCodecProvider = PojoCodecProvider.builder().register("edu.pucmm.eict.exercises",
                "edu.pucmm.eict.transactions", "edu.pucmm.eict.journals.ledger", "edu.pucmm.eict.journals.general").register(generalLedgerClassModel, generalJournalClassModel, solvedExerciseClassModel).conventions(Conventions.DEFAULT_CONVENTIONS).build();
        var pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        var solvedExerciseRepository = new SolvedExerciseRepository(mongoClient, pojoCodecRegistry);

        var app = Javalin.create(configuration -> {
            configuration.plugins.register(PluginsConfiguration.openApiPluginConfiguration());
            configuration.plugins.register(PluginsConfiguration.swaggerConfiguration());
            configuration.jsonMapper(PluginsConfiguration.jsonMapper());
        });

        var exerciseController = new ExerciseController(solvedExerciseRepository);
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.get("/solve-exercise/{solvedExerciseId}", exerciseController::getSolvedExerciseById);
        app.get("/solve-exercise/{solvedExerciseId}/pdf", exerciseController::getExercisePdf);
        app.exception(PDFGenerationErrorException.class, exerciseController::handlePdfGenerationErrorException);
        app.start(7000);
    }
}
