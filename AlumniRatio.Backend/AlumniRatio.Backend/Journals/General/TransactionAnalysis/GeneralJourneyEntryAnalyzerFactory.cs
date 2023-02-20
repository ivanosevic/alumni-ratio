using AlumniRatio.Backend.Transactions;

namespace AlumniRatio.Backend.Journals.General.TransactionAnalysis;

public class GeneralJourneyEntryAnalyzerFactory
{
    public static IGeneralJourneyEntryAnalyzer? Get(Transaction transaction)
    {
        return transaction.Type switch
        {
            TransactionType.OwnerInvestment => new OwnerInvestmentEntryAnalyzer(),
            TransactionType.OfficeSuppliesPurchase => new OfficeSuppliesPurchaseEntryAnalyzer(),
            TransactionType.None => null,
            TransactionType.OfficeEquipmentPurchase => null,
            TransactionType.LandPurchase => null,
            TransactionType.OfficeSuppliesPayment => null,
            TransactionType.OfficeEquipmentPayment => null,
            TransactionType.BankLoan => null,
            TransactionType.BankLoanPayment => null,
            TransactionType.ServiceRevenues => null,
            TransactionType.PublicServicesExpenses => null,
            TransactionType.RentExpenses => null,
            TransactionType.WagesExpenses => null,
            _ => null
        };
    }
}