package edu.pucmm.eict;

import io.javalin.Javalin;

public class AlumniRatioApplication {
    public static void main(String[] args)
    {
        var app = Javalin.create();
        var exerciseController = new ExerciseController();
        app.post("/solve-exercise", exerciseController::solveExercise);
        app.start(7000);
    }
}
