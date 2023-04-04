import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "../common/AmountInput";

interface RentExpensesTransactionProps {
    transaction: Transaction;
    onValueChange: (e: InputNumberValueChangeEvent) => void;
}


export default function RentExpensesTransaction(props: RentExpensesTransactionProps) {
    return (
        <AmountInput label="3. ¿Cuánto se pagará de renta?" amountValue={props.transaction?.amount ?? 0}
                     onAmountChangedEvent={props.onValueChange}/>
    );
}