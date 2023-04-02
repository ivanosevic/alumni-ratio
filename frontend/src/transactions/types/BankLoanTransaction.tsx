import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import {Transaction, TransactionType} from "../models/transaction.model";
import AmountInput from "../common/AmountInput";

interface BankLoanTransactionProps {
    transaction: Transaction;
    onValueChange: (e: InputNumberValueChangeEvent) => void;
}

export function BankLoanTransaction(props: BankLoanTransactionProps) {

    return (
        <AmountInput label="3. ¿Cuánto se tomo prestado del banco?" amountValue={props.transaction?.amount ?? 0}
                     onAmountChangedEvent={props.onValueChange}/>
    );
}