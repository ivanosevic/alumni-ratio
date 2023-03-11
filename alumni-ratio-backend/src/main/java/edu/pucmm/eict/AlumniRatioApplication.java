package edu.pucmm.eict;

import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiConfiguration;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.OpenApiPluginConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

public class AlumniRatioApplication {
    public static void main(String[] args) {
        var app = Javalin.create(configuration -> {
            configuration.plugins.register(new OpenApiPlugin(
                    new OpenApiPluginConfiguration()
                            .withDocumentationPath("/openapi")
                            .withDefinitionConfiguration((version, definition) -> definition
                                    .withOpenApiInfo((openApiInfo) -> {
                                        openApiInfo.setTitle("Alumni Ratio API");
                                        openApiInfo.setVersion("1.0.0");
                                    })
                                    .withServer((openApiServer) -> {
                                        openApiServer.setUrl(("http://localhost:{port}/" + version + "/"));
                                        openApiServer.setDescription("Server description goes here");
                                        openApiServer.addVariable("port", "7000", new String[]{"7070", "8080"}, "Port of the server");
                                    })
                            )
            ));

            SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
            configuration.plugins.register(new SwaggerPlugin(swaggerConfiguration));
        });
        var exerciseController = new ExerciseController();
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.start(7000);
    }
}
