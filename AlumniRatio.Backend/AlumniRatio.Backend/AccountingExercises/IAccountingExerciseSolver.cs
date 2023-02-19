namespace AlumniRatio.Backend.AccountingExercises;

public interface IAccountingExerciseSolver
{
    AccountingExerciseSolution Solve(AccountingExercise accountingExercise);
}