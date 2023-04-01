package edu.pucmm.eict.configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.javalin.json.JavalinJackson;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.OpenApiPluginConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

public class PluginsConfiguration {

    public static OpenApiPlugin openApiPluginConfiguration() {
        return new OpenApiPlugin(
                new OpenApiPluginConfiguration()
                        .withDocumentationPath("/openapi")
                        .withDefinitionConfiguration((version, definition) -> definition
                                .withOpenApiInfo((openApiInfo) -> {
                                    openApiInfo.setTitle("Alumni Ratio API");
                                    openApiInfo.setVersion("1.0.0");
                                })
                                .withServer((openApiServer) -> {
                                    openApiServer.setUrl(("http://localhost:7000/"));
                                    openApiServer.setDescription("Server description goes here");
                                })
                        )
        );
    }

    public static SwaggerPlugin swaggerConfiguration() {
        return new SwaggerPlugin(new SwaggerConfiguration());
    }

    public static JavalinJackson jsonMapper() {
        var javalinJackson = new JavalinJackson();
        javalinJackson.updateMapper(objectMapper -> {
            objectMapper.registerModule(new JavaTimeModule());
        });
        return javalinJackson;
    }
}
