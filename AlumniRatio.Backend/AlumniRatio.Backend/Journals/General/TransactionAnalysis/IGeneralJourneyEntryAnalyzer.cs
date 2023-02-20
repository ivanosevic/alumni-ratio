using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.Journals.General.TransactionAnalysis;

public interface IGeneralJourneyEntryAnalyzer
{
    GeneralJournalEntry CreateEntryBasedOnTransaction(int id, Transaction transaction);
}