package edu.pucmm.eict.exercises;

import edu.pucmm.eict.balance.TrialBalance;
import edu.pucmm.eict.journals.general.GeneralJournal;
import edu.pucmm.eict.journals.ledger.GeneralLedger;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.Objects;

public class SolvedExercise {

    @BsonId
    @BsonProperty("_id")
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private Exercise exercise;
    private GeneralJournal generalJournal;
    private GeneralLedger generalLedger;

    private TrialBalance trialBalance;

    public SolvedExercise() {
    }

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

    public SolvedExercise(Exercise exercise, GeneralJournal generalJournal, GeneralLedger generalLedger, TrialBalance trialBalance) {
        this.exercise = exercise;
        this.generalJournal = generalJournal;
        this.generalLedger = generalLedger;
        this.trialBalance = trialBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public TrialBalance getTrialBalance() {
        return trialBalance;
    }

    public void setTrialBalance(TrialBalance trialBalance) {
        this.trialBalance = trialBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolvedExercise that = (SolvedExercise) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SolvedExercise{" +
                "id='" + id + '\'' +
                ", exercise=" + exercise +
                ", generalJournal=" + generalJournal +
                ", generalLedger=" + generalLedger +
                '}';
    }
}
