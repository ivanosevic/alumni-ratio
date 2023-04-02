import {PaymentType, Transaction} from "../models/transaction.model";
import React from "react";
import {InputNumberValueChangeEvent} from "primereact/inputnumber";
import AmountInput from "./AmountInput";
import PaymentTypeDropdown, {PaymentTypeSelection} from "./PaymentTypeDropdown";
import {DropdownChangeEvent} from "primereact/dropdown";

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
  transaction: Transaction;
  onCreditChange: (e: InputNumberValueChangeEvent) => void;
  onDebitChange: (e: InputNumberValueChangeEvent) => void;
  onAmountChange: (e: InputNumberValueChangeEvent) => void;
  onPaymentTypeChange: (e: PaymentTypeSelection) => void;
}

export default function PaymentTransaction(props: PaymentTransactionProps) {

  return (
      <>
        <PaymentTypeDropdown transaction={props.transaction} onPaymentTypeChange={props.onPaymentTypeChange}
                             label="3. ¿La operación fue realizada al contado, crédito o mixta?"/>
        {props.transaction?.paymentType === PaymentType.CREDIT ?
            <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago a crédito?'}
                                             amount={props.transaction?.amount ?? 0}
                                             onAmountChangeEvent={props.onCreditChange}/> : null}

        {props.transaction?.paymentType === PaymentType.DEBIT ?
            <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago al contado?'}
                                             amount={props.transaction?.amount ?? 0}
                                             onAmountChangeEvent={props.onDebitChange}/> : null}

        {props.transaction?.paymentType === PaymentType.MIXED ? <>
          <DebitOrCreditPaymentTransaction label={'4. ¿Cuánto se pago a crédito?'}
                                           amount={props.transaction?.credit ?? 0}
                                           onAmountChangeEvent={props.onCreditChange}/>
          <DebitOrCreditPaymentTransaction label={'5. ¿Cuánto se pago al contado?'}
                                           amount={props.transaction?.debit ?? 0}
                                           onAmountChangeEvent={props.onDebitChange}/>
        </> : null}
      </>
  );
}