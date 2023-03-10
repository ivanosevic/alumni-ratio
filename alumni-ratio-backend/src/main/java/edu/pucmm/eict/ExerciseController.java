package edu.pucmm.eict;

import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseController {

    private final static Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    public void solveExercise(Context ctx) {
        Exercise exercise = ctx.bodyAsClass(Exercise.class);
        logger.info("{}", exercise);
        var exerciseSolver = new ExerciseSolver(exercise);
        var solvedExercise = exerciseSolver.solve();
        ctx.json(solvedExercise);
    }
}
