import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import {Transaction, TransactionType} from "../models/transaction.model";
import AmountInput from "../common/AmountInput";

interface BankLoanTransactionProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}

export function BankLoanTransaction(props: BankLoanTransactionProps) {

    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.BANK_LOAN
            }
        });
    }, []);

    const setAmountToTransaction = (e: InputNumberValueChangeEvent) => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                debit: 0,
                credit: 0,
                amount: e.value ?? 0
            }
        });
    }

    return (
        <AmountInput label="3. ¿Cuánto se tomo prestado del banco?" amountValue={props.transaction?.amount ?? 0} onAmountChangedEvent={setAmountToTransaction} />
    );
}