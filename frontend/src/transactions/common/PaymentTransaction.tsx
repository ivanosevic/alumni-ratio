import {PaymentType, Transaction} from "../models/transaction.model";
import React from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "./AmountInput";
import PaymentTypeDropdown from "./PaymentTypeDropdown";

interface CreditOrDebitPaymentProps {
    label: string;
    amount: number;
    onAmountChangeEvent: (e: InputNumberValueChangeEvent) => void;
}

function DebitOrCreditPaymentTransaction(props: CreditOrDebitPaymentProps) {
    return (
        <AmountInput label={props.label} amountValue={props.amount} onAmountChangedEvent={props.onAmountChangeEvent}/>
    )
}


interface MixedPaymentProps {
    labelCredit: string;
    labelDebit: string;
    amountCredit: number;
    amountDebit: number;
    onCreditAmountChangeEvent: (e: InputNumberValueChangeEvent) => void;
    onDebitAmountChangeEvent: (e: InputNumberValueChangeEvent) => void;
}

function MixedPaymentTransaction(props: MixedPaymentProps) {
    return (
        <>
            <AmountInput label={props.labelCredit} amountValue={props.amountCredit}
                         onAmountChangedEvent={props.onCreditAmountChangeEvent}/>
            <AmountInput label={props.labelDebit} amountValue={props.amountDebit}
                         onAmountChangedEvent={props.onDebitAmountChangeEvent}/>
        </>
    );
}


interface PaymentTransactionProps {
    transaction: Transaction | undefined;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction | undefined>>;
}

export default function PaymentTransaction(props: PaymentTransactionProps) {

    const setDebitToTransaction = (e: InputNumberValueChangeEvent) => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                amount: 0,
                debit: e.value ?? 0
            }
        });
    }

    const setCreditToTransaction = (e: InputNumberValueChangeEvent) => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                amount: 0,
                credit: e.value ?? 0
            }
        });
    }

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
        <>
            <PaymentTypeDropdown transaction={props.transaction} setTransaction={props.setTransaction}
                                 label="3. ¿La operación fue realizada al contado, crédito o mixta?"/>
            {props.transaction?.paymentType === PaymentType.CREDIT ?
                <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago a crédito?'}
                                                 amount={props.transaction?.amount ?? 0}
                                                 onAmountChangeEvent={setAmountToTransaction}/> : null}

            {props.transaction?.paymentType === PaymentType.DEBIT ?
                <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago al contado?'}
                                                 amount={props.transaction?.amount ?? 0}
                                                 onAmountChangeEvent={setAmountToTransaction}/> : null}

            {props.transaction?.paymentType === PaymentType.MIXED ? <>
                <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago a crédito?'}
                                                 amount={props.transaction?.credit ?? 0}
                                                 onAmountChangeEvent={setCreditToTransaction}/>
                <DebitOrCreditPaymentTransaction label={'5. ¿Cuánto se pago al contado?'}
                                                 amount={props.transaction?.debit ?? 0}
                                                 onAmountChangeEvent={setDebitToTransaction}/>
            </> : null}
        </>
    );
}