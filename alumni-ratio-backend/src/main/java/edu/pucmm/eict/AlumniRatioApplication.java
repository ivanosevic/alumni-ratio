package edu.pucmm.eict;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import edu.pucmm.eict.configuration.PluginsConfiguration;
import edu.pucmm.eict.exercises.ExerciseController;
import edu.pucmm.eict.exercises.SolvedExerciseRepository;
import edu.pucmm.eict.reports.exceptions.PDFGenerationErrorException;
import io.javalin.Javalin;
import org.bson.codecs.pojo.PojoCodecProvider;

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
        var pojoCodecProvider = PojoCodecProvider.builder().register("edu.pucmm.eict.exercises",
                "edu.pucmm.eict.transactions", "edu.pucmm.eict.journals.ledger", "edu.pucmm.eict.journals.general").build();
        var pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        var solvedExerciseRepository = new SolvedExerciseRepository(mongoClient, pojoCodecRegistry);

        var app = Javalin.create(configuration -> {
            configuration.plugins.register(PluginsConfiguration.openApiPluginConfiguration());
            configuration.plugins.register(PluginsConfiguration.swaggerConfiguration());
            configuration.jsonMapper(PluginsConfiguration.jsonMapper());
        });

        var exerciseController = new ExerciseController(solvedExerciseRepository);
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.get("/solve-exercise/{solvedExerciseId}/pdf", exerciseController::getExercisePdf);
        app.exception(PDFGenerationErrorException.class, exerciseController::handlePdfGenerationErrorException);
        app.start(7000);
    }
}
