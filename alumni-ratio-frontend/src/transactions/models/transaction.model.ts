export enum TransactionType {
  NONE,
  OWNER_INVESTMENT,
  OFFICE_SUPPLIES_PURCHASE,
  OFFICE_EQUIPMENT_PURCHASE,
  LAND_PURCHASE,
  OFFICE_SUPPLIES_PAYMENT,
  OFFICE_EQUIPMENT_PAYMENT,
  BANK_LOAN,
  BANK_LOAN_PAYMENT,
  SERVICE_REVENUES,
  PUBLIC_SERVICES_EXPENSES,
  RENT_EXPENSES,
  WAGES_EXPENSES
}

/**
 * Depending on the type of transaction, the payment type could be credit, debit or mixed with both.
 * For example, the company could buy some office materials with a 60% credit, and 40% debit split.
 * Meaning that the company pay 40% cash up front, to later pay the value.
 */
export enum PaymentType {
  CREDIT,
  DEBIT,
  MIXED
}

export class Transaction {
  id?: number;
  paymentType?: PaymentType;
  date?: Date;
  amount?: number = 0;
  debit?: number = 0;
  credit?: number = 0;
  type?: TransactionType;
  paymentReference?: number;
}