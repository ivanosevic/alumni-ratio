package edu.pucmm.eict.exercises;

import edu.pucmm.eict.journals.general.GeneralJournal;

import java.util.Objects;

public class SolvedExercise {
    private Exercise exercise;
    private GeneralJournal generalJournal;

    public SolvedExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public SolvedExercise(Exercise exercise, GeneralJournal generalJournal) {
        this.exercise = exercise;
        this.generalJournal = generalJournal;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public GeneralJournal getGeneralJournal() {
        return generalJournal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolvedExercise that = (SolvedExercise) o;
        return Objects.equals(exercise, that.exercise) && Objects.equals(generalJournal, that.generalJournal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exercise, generalJournal);
    }

    @Override
    public String toString() {
        return "SolvedExercise{" +
                "exercise=" + exercise +
                ", generalJournal=" + generalJournal +
                '}';
    }
}
