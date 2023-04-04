import {Transaction} from "../models/transaction.model";
import React from "react";

interface DownPaymentTransactionProps {
    transaction: Transaction | undefined;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction | undefined>>;
    transactions: Transaction[] | undefined;
}


export default function DownPaymentTransaction(props: DownPaymentTransactionProps) {

}