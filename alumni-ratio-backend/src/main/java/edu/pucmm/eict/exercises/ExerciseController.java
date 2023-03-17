package edu.pucmm.eict.exercises;

import edu.pucmm.eict.reports.ReportService;
import io.javalin.http.*;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.http.HttpHeaders;

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

    public void getExercisePdf(Context ctx) {
        Exercise exercise = ctx.bodyAsClass(Exercise.class);
        var exerciseSolver = new ExerciseSolver(exercise);
        var solvedExercise = exerciseSolver.solve();
        var reportService = new ReportService();
        try {
            var report = reportService.getSolvedExerciseReport(solvedExercise);
            var headers = ctx.headerMap();
            ctx.result(report.getContent())
                    .contentType(ContentType.APPLICATION_PDF)
                    .header(Header.CONTENT_DISPOSITION, "attachment; filename=exercise.pdf")
                    .header("Cache-Control", "no-cache, no-store, must-revalidate")
                    .header("Pragma", "no-cache")
                    .header("Expires", "0");
        } catch (IOException e) {
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
