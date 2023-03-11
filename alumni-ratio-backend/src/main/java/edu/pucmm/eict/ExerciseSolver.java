package edu.pucmm.eict;

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
