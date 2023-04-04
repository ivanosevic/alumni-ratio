package edu.pucmm.eict.exercises;

import edu.pucmm.eict.balance.TrialBalance;
import edu.pucmm.eict.journals.general.GeneralJournal;
import edu.pucmm.eict.journals.ledger.GeneralLedger;

public class ExerciseSolver {
    private final Exercise exercise;

    public ExerciseSolver(Exercise exercise) {
        this.exercise = exercise;
    }

    public SolvedExercise solve() {
        var generalJournal = new GeneralJournal(exercise);
        exercise.getTransactions().forEach(generalJournal::addTransactionAsEntry);
        var generalLedger = new GeneralLedger(exercise);
        generalLedger.carryOverFromGeneralJournal(generalJournal);
        var trialBalance = new TrialBalance();
        trialBalance.fillFromGeneralLedger(generalLedger);
        return new SolvedExercise(exercise, generalJournal, generalLedger, trialBalance);
    }
}
