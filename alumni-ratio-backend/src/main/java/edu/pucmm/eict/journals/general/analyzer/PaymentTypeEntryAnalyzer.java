package edu.pucmm.eict.journals.general.analyzer;

import edu.pucmm.eict.exercises.Exercise;
import edu.pucmm.eict.journals.general.GeneralJournalEntry;
import edu.pucmm.eict.transactions.PaymentType;
import edu.pucmm.eict.transactions.Transaction;

public interface PaymentTypeEntryAnalyzer extends GeneralJournalEntryAnalyzer {

    @Override
    default GeneralJournalEntry analyzeTransaction(Transaction transaction, Exercise exercise) {
        if (transaction.getPaymentType().equals(PaymentType.DEBIT)) {
            return this.debit(transaction, exercise);
        }

        if (transaction.getPaymentType().equals(PaymentType.CREDIT)) {
            return this.credit(transaction, exercise);
        }

        return this.mixed(transaction, exercise);
    }

    GeneralJournalEntry debit(Transaction transaction, Exercise exercise);

    GeneralJournalEntry credit(Transaction transaction, Exercise exercise);

    GeneralJournalEntry mixed(Transaction transaction, Exercise exercise);
}
