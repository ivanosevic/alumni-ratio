import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import PaymentTransaction from "../common/PaymentTransaction";

interface LandPurchaseTransactionProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}


export default function LandPurchaseTransaction(props: LandPurchaseTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.LAND_PURCHASE
            }
        });
    }, []);

    return (
        <>
            <PaymentTransaction transaction={props.transaction} setTransaction={props.setTransaction} />
        </>
    );
}