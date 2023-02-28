package edu.pucmm.eict;

public class SolvedExercise
{
    private Exercise exercise;
    private GeneralJournal generalJournal;

    public SolvedExercise(Exercise exercise, GeneralJournal generalJournal)
    {
        this.exercise = exercise;
        this.generalJournal = generalJournal;
    }

    public Exercise getExercise()
    {
        return exercise;
    }

    public GeneralJournal getGeneralJournal()
    {
        return generalJournal;
    }
}
