namespace AlumniRatio.Backend.Journals.General;

public class GeneralJournalRow
{
    public int Reference { get; set; }
    public double Debit { get; set; }
    public double Credit { get; set; }
    public string Detail { get; set; }

    public GeneralJournalRow(int reference, double debit, double credit, string detail)
    {
        Reference = reference;
        Debit = debit;
        Credit = credit;
        Detail = detail;
    }

    public bool IsDebit()
    {
        return Debit > 0;
    }

    public bool IsCredit()
    {
        return Credit > 0;
    }
}