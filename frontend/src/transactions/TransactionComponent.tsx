import {Transaction, TransactionType} from "./models/transaction.model";
import React, {useState} from "react";
import {Card} from "primereact/card";
import {Calendar, CalendarChangeEvent} from "primereact/calendar";
import {Dropdown, DropdownChangeEvent} from "primereact/dropdown";
import OwnerInvestmentTransaction from "./types/OwnerInvestmentTransaction";
import OfficeSuppliesPurchaseTransaction from "./types/OfficeSuppliesPurchaseTransaction";
import LandPurchaseTransaction from "./types/LandPurchaseTransaction";
import {BankLoanTransaction} from "./types/BankLoanTransaction";
import ServiceRevenuesTransaction from "./types/ServiceRevenuesTransaction";
import PublicServicesExpensesTransaction from "./types/PublicServicesExpensesTransaction";
import RentExpensesTransaction from "./types/RentExpensesTransaction";
import WagesExpensesTransaction from "./types/WagesExpensesTransaction";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import {PaymentTypeSelection} from "./common/PaymentTypeDropdown";
import {Button} from "primereact/button";

/**
 * This class is used when selecting the nature of the transaction on a dropdown.
 * The dropdown will show the label attribute, and the type will be attached so the enum
 * value is easier to retrieve.
 */
class TransactionTypeSelection {
  type?: TransactionType;
  label?: string;
}

interface TransactionComponentProps {
  transactions: Transaction[];
  setTransactions: React.Dispatch<React.SetStateAction<Transaction[]>>;
}


export default function TransactionComponent(props: TransactionComponentProps) {
  const transactionTypeSelections: TransactionTypeSelection[] = [
    {
      label: 'Inversión del dueño al negocio',
      type: TransactionType.OWNER_INVESTMENT
    },
    {
      label: 'Compra de materiales de oficina',
      type: TransactionType.OFFICE_SUPPLIES_PURCHASE
    },
    {
      label: 'Compra de equipos de oficina',
      type: TransactionType.OFFICE_EQUIPMENT_PURCHASE
    },
    {
      label: 'Compra de terreno',
      type: TransactionType.LAND_PURCHASE
    },
    {
      label: 'Préstamo Bancario',
      type: TransactionType.BANK_LOAN
    },
    {
      label: 'Ingresos por servicios',
      type: TransactionType.SERVICE_REVENUES
    },
    {
      label: 'Pago de renta',
      type: TransactionType.RENT_EXPENSES
    },
    {
      label: 'Pago de sueldos',
      type: TransactionType.WAGES_EXPENSES
    },
    {
      label: 'Pago de servicios públicos',
      type: TransactionType.PUBLIC_SERVICES_EXPENSES
    }
  ];

  const changeTransactionValueProperty = (e: InputNumberValueChangeEvent, i: number) => {
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].amount = e.value ?? 0
      return tempTransactions;
    });
  };

  const changeTransactionDateProperty = (e: CalendarChangeEvent, i: number) => {
    const newDate = e.value as Date;
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].date = newDate;
      return tempTransactions;
    });
  };

  const changeTransactionTypeProperty = (i: number, value: TransactionTypeSelection) => {
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].type = value.type;
      return tempTransactions;
    });
  };

  const changeTransactionCreditProperty = (e: InputNumberValueChangeEvent, i: number) => {
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].credit = e.value ?? 0
      return tempTransactions;
    });
  };

  const changeTransactionDebitProperty = (e: InputNumberValueChangeEvent, i: number) => {
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].debit = e.value ?? 0
      return tempTransactions;
    });
  };

  const changeTransactionPaymentTypeProperty = (i: number, e: PaymentTypeSelection) => {
    props.setTransactions(prevState => {
      const tempTransactions = [...prevState];
      tempTransactions[i].paymentType = e.type
      return tempTransactions;
    });
  };

  const deleteTransactionsOnClick = (index: number) => {
    props.setTransactions(prevState => {
      return prevState.filter((_, i) => i !== index);
    });
  }

  return (
      <>
        {props.transactions.map((t, index) => {
          return (
              <Card title={'Transacción ' + (index+1)} className="mb-3" key={index}>
                <div className="formgrid grid">
                  <section className="col-12">
                    <div className="field">
                      <label>1. Selecciona la fecha de la transacción</label>
                      <div className="col">
                        <Calendar className="w-full md:w-5" value={t.date}
                                  onChange={(e: CalendarChangeEvent) => changeTransactionDateProperty(e, index)}
                                  showIcon/>
                      </div>
                    </div>
                  </section>
                  <section className="col-12">
                    <div className="field">
                      <label>2. ¿Qué clase de operación se realizó en esta transacción?</label>
                      <div className="col">
                        <Dropdown value={transactionTypeSelections.find(value => value.type === t.type)}
                                  onChange={(e) => changeTransactionTypeProperty(index, e.value)}
                                  options={transactionTypeSelections} optionLabel="label" className="w-full md:w-5"
                                  placeholder="Seleccione la operación realizada"/>
                      </div>
                    </div>
                  </section>
                  <section className="col-12">
                    {t.type === TransactionType.OWNER_INVESTMENT ?
                        <OwnerInvestmentTransaction transaction={t}
                                                    onValueChange={(e: InputNumberValueChangeEvent) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.OFFICE_SUPPLIES_PURCHASE ?
                        <OfficeSuppliesPurchaseTransaction transaction={t}
                                                           onPaymentTypeChange={(e) => changeTransactionPaymentTypeProperty(index, e)}
                                                           onDebitChange={(e) => changeTransactionDebitProperty(e, index)}
                                                           onCreditChange={(e) => changeTransactionCreditProperty(e, index)}
                                                           onAmountChange={(e) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.OFFICE_EQUIPMENT_PURCHASE ?
                        <OfficeSuppliesPurchaseTransaction transaction={t}
                                                           onPaymentTypeChange={(e) => changeTransactionPaymentTypeProperty(index, e)}
                                                           onDebitChange={(e) => changeTransactionDebitProperty(e, index)}
                                                           onCreditChange={(e) => changeTransactionCreditProperty(e, index)}
                                                           onAmountChange={(e) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.LAND_PURCHASE ?
                        <LandPurchaseTransaction transaction={t}
                                                 onPaymentTypeChange={(e) => changeTransactionPaymentTypeProperty(index, e)}
                                                 onDebitChange={(e) => changeTransactionDebitProperty(e, index)}
                                                 onCreditChange={(e) => changeTransactionCreditProperty(e, index)}
                                                 onAmountChange={(e) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.BANK_LOAN ?
                        <BankLoanTransaction transaction={t}
                                             onValueChange={(e: InputNumberValueChangeEvent) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.SERVICE_REVENUES ?
                        <ServiceRevenuesTransaction transaction={t}
                                                    onPaymentTypeChange={(e) => changeTransactionPaymentTypeProperty(index, e)}
                                                    onDebitChange={(e) => changeTransactionDebitProperty(e, index)}
                                                    onCreditChange={(e) => changeTransactionCreditProperty(e, index)}
                                                    onAmountChange={(e) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.PUBLIC_SERVICES_EXPENSES ?
                        <PublicServicesExpensesTransaction transaction={t}
                                                           onValueChange={(e: InputNumberValueChangeEvent) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.RENT_EXPENSES ?
                        <RentExpensesTransaction transaction={t}
                                                 onValueChange={(e: InputNumberValueChangeEvent) => changeTransactionValueProperty(e, index)}/> : null}
                    {t.type === TransactionType.WAGES_EXPENSES ?
                        <WagesExpensesTransaction transaction={t}
                                                  onValueChange={(e: InputNumberValueChangeEvent) => changeTransactionValueProperty(e, index)}/> : null}
                  </section>
                  <section className="flex w-full justify-content-end">
                    <Button severity="danger" icon="pi pi-trash" onClick={() => deleteTransactionsOnClick(index)}/>
                  </section>
                </div>
              </Card>
          );
        })}
      </>
  );
}