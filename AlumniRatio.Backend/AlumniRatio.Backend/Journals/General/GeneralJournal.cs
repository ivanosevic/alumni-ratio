using AlumniRatio.Backend.Journals.General.TransactionAnalysis;
using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.Journals.General;

public class GeneralJournal
{
    private readonly IList<GeneralJournalEntry> _entries;

    public GeneralJournal()
    {
        _entries = new List<GeneralJournalEntry>();
    }

    public void AddTransactionToJournal(Transaction transaction)
    {
        var nextEntryId = _entries.Count + 1;
        var generalJourneyEntryAnalyzer = GeneralJourneyEntryAnalyzerFactory.Get(transaction);
        var journalEntry = generalJourneyEntryAnalyzer?.CreateEntryBasedOnTransaction(nextEntryId, transaction);
        if (journalEntry != null)
        {
            _entries.Add(journalEntry);
        }
    }
    
    public IList<GeneralJournalEntry> GetAllEntries()
    {
        return _entries;
    }
}