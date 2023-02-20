using AlumniRatio.Backend.Accounts;
using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.Journals.General.TransactionAnalysis;

public class OfficeSuppliesPurchaseEntryAnalyzer : IGeneralJourneyEntryAnalyzer
{
    public GeneralJournalEntry CreateEntryBasedOnTransaction(int id, Transaction transaction)
    {
        var journalEntry = new GeneralJournalEntry(id);
        
        if (transaction.PaymentType.GetValueOrDefault().Equals(PaymentType.Debit))
        {
            var officeSuppliesAccount = new GeneralJournalRow(AccountBook.OFFICE_SUPPLIES_ACCOUNT.Number, transaction.Debit.GetValueOrDefault(), 0, AccountBook.OFFICE_SUPPLIES_ACCOUNT.Name);
            var cashEntry = new GeneralJournalRow(AccountBook.CASH_ACCOUNT.Number, 0 , transaction.Debit.GetValueOrDefault(), AccountBook.CASH_ACCOUNT.Name);
            journalEntry.Explanation = "Para registrar compra de materiales a débito.";
            journalEntry.AddRow(officeSuppliesAccount);
            journalEntry.AddRow(cashEntry);
        }
        
        else if (transaction.PaymentType.GetValueOrDefault().Equals(PaymentType.Credit))
        {
            var officeSuppliesAccount = new GeneralJournalRow(AccountBook.OFFICE_SUPPLIES_ACCOUNT.Number, transaction.Credit.GetValueOrDefault(), 0, AccountBook.OFFICE_SUPPLIES_ACCOUNT.Name);
            var payableAccount = new GeneralJournalRow(AccountBook.PAYABLE_ACCOUNT.Number, 0 , transaction.Credit.GetValueOrDefault(), AccountBook.PAYABLE_ACCOUNT.Name);
            journalEntry.Explanation = "Para registrar compra de materiales a crédito.";
            journalEntry.AddRow(officeSuppliesAccount);
            journalEntry.AddRow(payableAccount);
        }

        else
        {
            var total = (transaction.Debit.GetValueOrDefault() + transaction.Credit.GetValueOrDefault());
            var officeSuppliesAccount = new GeneralJournalRow(AccountBook.OFFICE_SUPPLIES_ACCOUNT.Number, total, 0, AccountBook.OFFICE_SUPPLIES_ACCOUNT.Name);
            var cashEntry = new GeneralJournalRow(AccountBook.CASH_ACCOUNT.Number, 0 , transaction.Debit.GetValueOrDefault(), AccountBook.CASH_ACCOUNT.Name);
            var payableAccount = new GeneralJournalRow(AccountBook.PAYABLE_ACCOUNT.Number, 0 , transaction.Credit.GetValueOrDefault(), AccountBook.PAYABLE_ACCOUNT.Name);
            journalEntry.Explanation = "Para registrar compra de materiales a crédito y débito.";
            journalEntry.AddRow(officeSuppliesAccount);
            journalEntry.AddRow(cashEntry);
            journalEntry.AddRow(payableAccount);
        }
        return journalEntry;
    }
}