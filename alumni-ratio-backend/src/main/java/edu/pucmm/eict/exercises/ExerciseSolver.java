package edu.pucmm.eict.exercises;

public class ExerciseSolver
{
    private final Exercise exercise;

    public ExerciseSolver(Exercise exercise)
    {
        this.exercise = exercise;
    }

    public SolvedExercise solve()
    {
        return new SolvedExercise(exercise);
    }
}
