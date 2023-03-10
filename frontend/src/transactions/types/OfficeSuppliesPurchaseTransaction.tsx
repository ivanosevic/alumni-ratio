import {Transaction, TransactionType} from "../models/transaction.model";
import React, {useEffect} from "react";
import PaymentTransaction from "../common/PaymentTransaction";

interface OfficeSuppliesPurchaseTransactionProps {
    transaction: Transaction | undefined;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction | undefined>>;
}


export default function OfficeSuppliesPurchaseTransaction(props: OfficeSuppliesPurchaseTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.OFFICE_SUPPLIES_PURCHASE
            }
        });
    }, []);

    return (
        <>
            <PaymentTransaction transaction={props.transaction} setTransaction={props.setTransaction} />
        </>
    );
}