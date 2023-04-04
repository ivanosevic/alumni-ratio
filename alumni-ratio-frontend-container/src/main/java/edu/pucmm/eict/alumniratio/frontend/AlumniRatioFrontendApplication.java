package edu.pucmm.eict.alumniratio.frontend;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;

public class AlumniRatioFrontendApplication {
    public static void main(String[] args) {
        int appPort = Integer.parseInt(System.getenv("APP_PORT"));

        JavalinRenderer.register(new JavalinThymeleaf(ThymeleafConfiguration.templateEngine()), ".html");

        var app = Javalin.create(configuration -> {
            configuration.staticFiles.add(staticFileConfig -> {
                staticFileConfig.location = Location.CLASSPATH;
                staticFileConfig.directory = "/application/assets";
                staticFileConfig.hostedPath = "/assets";
            });
        });

        /*
            Show the SPA at the root of the web page.
            The SPA will handle all routes and lifecycle of the
            app, after that.
         */
        app.get("/", ctx -> ctx.render("/application/index.html"));

        app.start(appPort);
    }
}