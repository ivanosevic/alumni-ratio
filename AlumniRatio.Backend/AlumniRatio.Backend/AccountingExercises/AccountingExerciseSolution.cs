using AlumniRatio.Backend.Journals.General;

namespace AlumniRatio.Backend.AccountingExercises;

public class AccountingExerciseSolution
{
    public string Id { get; set; }
    public AccountingExercise AccountingExercise { get; set; }
    public GeneralJournal GeneralJournal { get; set; }

    public AccountingExerciseSolution(string id, AccountingExercise accountingExercise, GeneralJournal generalJournal)
    {
        Id = id;
        AccountingExercise = accountingExercise;
        GeneralJournal = generalJournal;
    }
}