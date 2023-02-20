namespace AlumniRatio.Backend.Journals.General;

public class GeneralJournalEntry
{
    public int Id { get; set; }
    public string Explanation { get; set; }
    private readonly IList<GeneralJournalRow> Rows;

    public GeneralJournalEntry(int id)
    {
        Id = id;
    }

    public GeneralJournalEntry(int id, string explanation)
    {
        Id = id;
        Explanation = explanation;
        Rows = new List<GeneralJournalRow>();
    }

    public Tuple<double, double> SumUpEntries()
    {
        var creditEntriesSum = Rows.Where(row => row.IsCredit()).Sum(row => row.Credit);
        var debitEntriesSum = Rows.Where(row => row.IsDebit()).Sum(row => row.Debit);
        return new Tuple<double, double>(creditEntriesSum, debitEntriesSum);
    }

    public void AddRow(GeneralJournalRow row)
    {
        Rows.Add(row);
    }

    public IList<GeneralJournalRow> GetAllCreditRows()
    {
        return Rows.Where(row => row.IsCredit()).ToList();
    }
    
    public IList<GeneralJournalRow> GetAllDebitRows()
    {
        return Rows.Where(row => row.IsDebit()).ToList();
    }
}