import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "../common/AmountInput";

interface RentExpensesTransactionProps {
    transaction: Transaction | undefined;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction | undefined>>;
}


export default function RentExpensesTransaction(props: RentExpensesTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.RENT_EXPENSES
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
        <AmountInput label="3. ¿Cuánto se pagará de renta?" amountValue={props.transaction?.amount ?? 0} onAmountChangedEvent={setAmountToTransaction} />
    );
}