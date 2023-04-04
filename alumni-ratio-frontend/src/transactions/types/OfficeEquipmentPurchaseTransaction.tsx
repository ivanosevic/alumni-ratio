import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import PaymentTransaction from "../common/PaymentTransaction";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import {DropdownChangeEvent} from "primereact/dropdown";
import {PaymentTypeSelection} from "../common/PaymentTypeDropdown";

interface OfficeEquipmentPurchaseTransactionProps {
  transaction: Transaction;
  onCreditChange: (e: InputNumberValueChangeEvent) => void;
  onDebitChange: (e: InputNumberValueChangeEvent) => void;
  onAmountChange: (e: InputNumberValueChangeEvent) => void;
  onPaymentTypeChange: (e: PaymentTypeSelection) => void;
}


export default function OfficeEquipmentPurchaseTransaction(props: OfficeEquipmentPurchaseTransactionProps) {
  return (
      <>
        <PaymentTransaction transaction={props.transaction} onPaymentTypeChange={props.onPaymentTypeChange}
                            onAmountChange={props.onAmountChange} onCreditChange={props.onCreditChange}
                            onDebitChange={props.onDebitChange}/>
      </>
  );
}