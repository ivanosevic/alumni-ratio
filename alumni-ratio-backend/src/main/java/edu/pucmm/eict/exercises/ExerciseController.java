package edu.pucmm.eict.exercises;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseController {

    private final static Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @OpenApi(
            summary = "Solves a simple accounting exercise",
            operationId = "solveExercise",
            path = "/solve-exercise",
            methods = HttpMethod.POST,
            tags = {"Exercises"},
            responses = {
                    @OpenApiResponse(status = "200", content = {@OpenApiContent(from = SolvedExercise.class)}),
                    @OpenApiResponse(status = "400", content = {@OpenApiContent(from = BadRequestResponse.class)}),
                    @OpenApiResponse(status = "500", content = {@OpenApiContent(from = InternalServerErrorResponse.class)})
            }
    )
    public void solveExercise(Context ctx) {
        Exercise exercise = ctx.bodyAsClass(Exercise.class);
        var exerciseSolver = new ExerciseSolver(exercise);
        var solvedExercise = exerciseSolver.solve();
        ctx.json(solvedExercise);
    }
}
