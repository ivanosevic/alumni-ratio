package edu.pucmm.eict.exercises;

import edu.pucmm.eict.journals.general.GeneralJournal;
import edu.pucmm.eict.journals.ledger.GeneralLedger;

import java.util.Objects;

public class SolvedExercise {
    private final Exercise exercise;
    private GeneralJournal generalJournal;
    private GeneralLedger generalLedger;

    public SolvedExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public SolvedExercise(Exercise exercise, GeneralJournal generalJournal) {
        this.exercise = exercise;
        this.generalJournal = generalJournal;
    }

    public SolvedExercise(Exercise exercise, GeneralJournal generalJournal, GeneralLedger generalLedger) {
        this.exercise = exercise;
        this.generalJournal = generalJournal;
        this.generalLedger = generalLedger;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public GeneralJournal getGeneralJournal() {
        return generalJournal;
    }

    public void setGeneralJournal(GeneralJournal generalJournal) {
        this.generalJournal = generalJournal;
    }

    public GeneralLedger getGeneralLedger() {
        return generalLedger;
    }

    public void setGeneralLedger(GeneralLedger generalLedger) {
        this.generalLedger = generalLedger;
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
