using AlumniRatio.Backend.Accounts;
using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.Journals.General.TransactionAnalysis;

public class OwnerInvestmentEntryAnalyzer : IGeneralJourneyEntryAnalyzer
{
    public GeneralJournalEntry CreateEntryBasedOnTransaction(int id, Transaction transaction)
    {
        var cashEntry = new GeneralJournalRow(AccountBook.CASH_ACCOUNT.Number, transaction.Amount.GetValueOrDefault() , 0, AccountBook.CASH_ACCOUNT.Name);
        var capitalEntry = new GeneralJournalRow(AccountBook.CAPITAL_ACCOUNT.Number, 0, transaction.Amount.GetValueOrDefault(), AccountBook.CAPITAL_ACCOUNT.Name);
        var journalEntry = new GeneralJournalEntry(id, "Para registrar inversión inicial del propietario.");
        journalEntry.AddRow(cashEntry);
        journalEntry.AddRow(capitalEntry);
        return journalEntry;
    }
}