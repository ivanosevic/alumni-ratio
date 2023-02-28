package edu.pucmm.eict;

public class SolvedExercise
{
    private Exercise exercise;
    private GeneralJourney generalJourney;

    public SolvedExercise(Exercise exercise, GeneralJourney generalJourney)
    {
        this.exercise = exercise;
        this.generalJourney = generalJourney;
    }

    public Exercise getExercise()
    {
        return exercise;
    }

    public GeneralJourney getGeneralJourney()
    {
        return generalJourney;
    }
}
