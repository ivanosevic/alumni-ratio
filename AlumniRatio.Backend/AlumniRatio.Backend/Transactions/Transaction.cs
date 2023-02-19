namespace AlumniRatio.Backend.Transactions;

/// <summary>
///  Accounting transactions refer to any business activity that results in a direct effect on the
/// financial status and financial statements of the business. Depending on the type of the transaction,
/// many attribute will change.
/// </summary>
public class Transaction
{
    /// <value>
    /// Any transaction needs an id, regardless of the type. This id represents the order of the transaction.
    /// </value>
    public int Id { get; set; }
    
    /// <value>
    /// If the transaction involves paying debit, credit or a mix of both, then it will have this attribute.
    /// </value>
    public PaymentType? PaymentType { get; set; }
    
    /// <value>
    /// The day which the transaction occurred.
    /// </value>
    public int Day { get; set; }
    
    /// <value>
    /// If it doesn't specify any payment type, the amount of cash will be in this attribute.
    /// </value>
    public double? Amount { get; set; }
    
    /// <value>
    /// If the paymentType is debit, the value will be stored here.
    /// </value>
    public double? Debit { get; set; }
    
    /// <value>
    /// If the paymentType is credit, the value will be stored here.
    /// </value>
    public double? Credit { get; set; }
    
    /// <value>
    /// The nature of the transaction.
    /// </value>
    public TransactionType Type { get; set; }
    
    /// <value>
    /// If the transaction was a payment, it needs a reference to a valid previous transaction.
    /// </value>
    public int? TransactionReferenceId { get; set; }
}