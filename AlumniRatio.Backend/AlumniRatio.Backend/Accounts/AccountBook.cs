namespace AlumniRatio.Backend.Accounts;

public class AccountBook
{
    public record AccountBookMetadata(int Number, string Name, AccountType Type);

    public static AccountBookMetadata CASH_ACCOUNT = new AccountBookMetadata(101, "Efectivo", AccountType.Active);

    public static AccountBookMetadata OFFICE_SUPPLIES_ACCOUNT =
        new AccountBookMetadata(102, "Materiales de Oficina", AccountType.Active);

    public static AccountBookMetadata PAYABLE_ACCOUNT =
        new AccountBookMetadata(201, "Cuentas por pagar", AccountType.Passive);

    public static AccountBookMetadata CAPITAL_ACCOUNT = new AccountBookMetadata(301, "Capital", AccountType.Active);
}