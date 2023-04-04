package edu.pucmm.eict.alumniratio.exercises;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;

import java.util.Optional;

public class SolvedExerciseRepository {

    private final MongoClient mongoClient;
    private final CodecRegistry codecRegistry;

    public SolvedExerciseRepository(MongoClient mongoClient, CodecRegistry codecRegistry) {
        this.mongoClient = mongoClient;
        this.codecRegistry = codecRegistry;
    }

    public void saveSolvedExercise(SolvedExercise solvedExercise) {
        var database = mongoClient.getDatabase("BaseDeDatosContable").withCodecRegistry(codecRegistry);
        var collection = database.getCollection("solvedExercise", SolvedExercise.class);
        var result = collection.insertOne(solvedExercise);
        solvedExercise.setId(result.getInsertedId().asObjectId().getValue().toString());
    }

    public Optional<SolvedExercise> findById(String solvedExerciseId) {
        var database = mongoClient.getDatabase("BaseDeDatosContable").withCodecRegistry(codecRegistry);
        var collection = database.getCollection("solvedExercise", SolvedExercise.class);
        var solvedExercise = collection.find(Filters.eq("_id", new ObjectId(solvedExerciseId))).first();
        return Optional.ofNullable(solvedExercise);
    }
}
