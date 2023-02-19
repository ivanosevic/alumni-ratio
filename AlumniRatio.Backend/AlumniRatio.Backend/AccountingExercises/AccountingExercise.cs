using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.AccountingExercises;

public class AccountingExercise
{
    public string CompanyOwner { get; set; }
    public string CompanyName { get; set; }
    public int Year { get; set; }
    public int Month { get; set; }
    public IEnumerable<Transaction> Transactions { get; set; }
}