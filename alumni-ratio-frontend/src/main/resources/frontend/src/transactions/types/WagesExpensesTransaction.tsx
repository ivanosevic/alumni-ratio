import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "../common/AmountInput";

interface WagesExpensesTransactionProps {
  transaction: Transaction;
  onValueChange: (e: InputNumberValueChangeEvent) => void;
}


export default function WagesExpensesTransaction(props: WagesExpensesTransactionProps) {
  return (
      <AmountInput label="3. ¿Cuánto se les pagará a los empleados?" amountValue={props.transaction?.amount ?? 0}
                   onAmountChangedEvent={props.onValueChange}/>
  );
}