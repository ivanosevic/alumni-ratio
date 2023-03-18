package edu.pucmm.eict.exercises;

import edu.pucmm.eict.reports.exceptions.PDFGenerationErrorException;
import edu.pucmm.eict.reports.SolvedExerciseReportService;
import io.javalin.http.*;
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

    public void getExercisePdf(Context ctx) {
        Exercise exercise = ctx.bodyAsClass(Exercise.class);
        var exerciseSolver = new ExerciseSolver(exercise);
        var solvedExercise = exerciseSolver.solve();
        var reportService = new SolvedExerciseReportService();
        var report = reportService.getSolvedExerciseReport(solvedExercise);
        ctx.result(report.getContent())
                .contentType(ContentType.APPLICATION_PDF)
                .header(Header.CONTENT_DISPOSITION, "attachment; filename=exercise.pdf")
                .header("Cache-Control", "no-cache, no-store, must-revalidate")
                .header("Pragma", "no-cache")
                .header("Expires", "0");
    }

    public void handlePdfGenerationErrorException(PDFGenerationErrorException ex, Context ctx) {
        ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
        logger.error("Error while generating PDF Report: { }", ex);
        logger.error("Further Details: { }", ex.getFurtherDetails());
    }
}
