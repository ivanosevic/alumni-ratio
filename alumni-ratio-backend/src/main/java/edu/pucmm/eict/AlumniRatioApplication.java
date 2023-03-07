package edu.pucmm.eict;


import io.javalin.Javalin;

public class AlumniRatioApplication {
    public static void main(String[] args)
    {
        var app = Javalin.create(/*config*/)
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);

    }
}
