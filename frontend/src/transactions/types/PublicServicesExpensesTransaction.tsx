import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "../common/AmountInput";

interface PublicServicesExpensesTransactionProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}


export default function PublicServicesExpensesTransaction(props: PublicServicesExpensesTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.PUBLIC_SERVICES_EXPENSES
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
        <AmountInput label="3. ¿Cuánto se pagará de servicios públicos?" amountValue={props.transaction?.amount ?? 0} onAmountChangedEvent={setAmountToTransaction} />
    );
}