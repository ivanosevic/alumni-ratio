package edu.pucmm.eict;

import edu.pucmm.eict.configuration.PluginsConfiguration;
import edu.pucmm.eict.exercises.ExerciseController;
import edu.pucmm.eict.reports.exceptions.PDFGenerationErrorException;
import io.javalin.Javalin;


public class AlumniRatioApplication {
    public static void main(String[] args) {
        var app = Javalin.create(configuration -> {
            configuration.plugins.register(PluginsConfiguration.openApiPluginConfiguration());
            configuration.plugins.register(PluginsConfiguration.swaggerConfiguration());
            configuration.jsonMapper(PluginsConfiguration.jsonMapper());
        });
        var exerciseController = new ExerciseController();
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.post("/solve-exercise/pdf", exerciseController::getExercisePdf);
        app.exception(PDFGenerationErrorException.class, exerciseController::handlePdfGenerationErrorException);
        app.start(7000);
    }
}
