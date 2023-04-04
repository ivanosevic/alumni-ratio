package edu.pucmm.eict.alumniratio.exercises;

import edu.pucmm.eict.alumniratio.reports.exceptions.PDFGenerationErrorException;
import edu.pucmm.eict.alumniratio.reports.SolvedExerciseReportService;
import io.javalin.http.*;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiContent;
import io.javalin.openapi.OpenApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExerciseController {

    private final static Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    private final SolvedExerciseRepository solvedExerciseRepository;

    public ExerciseController(SolvedExerciseRepository solvedExerciseRepository) {
        this.solvedExerciseRepository = solvedExerciseRepository;
    }

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
        solvedExerciseRepository.saveSolvedExercise(solvedExercise);
        ctx.json(solvedExercise);
    }

    public void getExercisePdf(Context ctx) {
        var solvedExerciseId = ctx.pathParam("solvedExerciseId");
        var solvedExercise = solvedExerciseRepository.findById(solvedExerciseId);
        solvedExercise.ifPresentOrElse(se -> {
            var reportService = new SolvedExerciseReportService();
            var report = reportService.getSolvedExerciseReport(se);
            ctx.result(report.getContent())
                    .contentType(ContentType.APPLICATION_PDF)
                    .header(Header.CONTENT_DISPOSITION, "attachment; filename=exercise.pdf")
                    .header("Cache-Control", "no-cache, no-store, must-revalidate")
                    .header("Pragma", "no-cache")
                    .header("Expires", "0");
        }, () -> {
            var errorMessage = Map.of("message", "El ejercicio para sacar el PDF no esta disponible en nuestro sistema.");
            ctx.status(HttpStatus.NOT_FOUND).json(errorMessage);
        });

    }

    public void handlePdfGenerationErrorException(PDFGenerationErrorException ex, Context ctx) {
        ctx.status(HttpStatus.INTERNAL_SERVER_ERROR);
        logger.error("Error while generating PDF Report: { }", ex);
        logger.error("Further Details: { }", ex.getFurtherDetails());
    }

    public void getSolvedExerciseById(Context ctx) {
        var solvedExerciseId = ctx.pathParam("solvedExerciseId");
        var solvedExercise = solvedExerciseRepository.findById(solvedExerciseId);
        solvedExercise.ifPresentOrElse(ctx::json, () -> {
            var errorMessage = Map.of("message", "El ejercicio no se encuentra en el sistema.");
            ctx.status(HttpStatus.NOT_FOUND).json(errorMessage);
        });
    }
}
