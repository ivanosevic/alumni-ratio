import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import PaymentTransaction from "../common/PaymentTransaction";

interface ServiceRevenuesTransactionProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}


export default function ServiceRevenuesTransaction(props: ServiceRevenuesTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.SERVICE_REVENUES
            }
        });
    }, []);

    return (
        <>
            <PaymentTransaction transaction={props.transaction} setTransaction={props.setTransaction}/>
        </>
    );
}