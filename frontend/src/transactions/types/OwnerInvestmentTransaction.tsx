import React, {useEffect} from "react";
import {InputNumberValueChangeEvent,} from "primereact/inputnumber";
import {Transaction, TransactionType} from "../models/transaction.model";
import AmountInput from "../common/AmountInput";

interface OwnerInvestmentTransactionProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}

function OwnerInvestmentTransaction(props: OwnerInvestmentTransactionProps) {
    useEffect(() => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                type: TransactionType.OWNER_INVESTMENT
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
        <AmountInput label="3. ¿Cuánto invirtió el dueño en el negocio?" amountValue={props.transaction?.amount ?? 0} onAmountChangedEvent={setAmountToTransaction} />
    );
}

export default OwnerInvestmentTransaction;
