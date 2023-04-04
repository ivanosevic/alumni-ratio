import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "../common/AmountInput";

interface PublicServicesExpensesTransactionProps {
  transaction: Transaction;
  onValueChange: (e: InputNumberValueChangeEvent) => void;
}


export default function PublicServicesExpensesTransaction(props: PublicServicesExpensesTransactionProps) {

  return (
      <AmountInput label="3. ¿Cuánto se pagará de servicios públicos?" amountValue={props.transaction?.amount ?? 0}
                   onAmountChangedEvent={props.onValueChange}/>
  );
}