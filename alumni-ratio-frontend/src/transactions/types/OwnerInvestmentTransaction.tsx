import React, {useEffect} from "react";
import {InputNumberValueChangeEvent,} from "primereact/inputnumber";
import {Transaction} from "../models/transaction.model";
import AmountInput from "../common/AmountInput";

interface OwnerInvestmentTransactionProps {
  transaction: Transaction;
  onValueChange: (e: InputNumberValueChangeEvent) => void;
}

function OwnerInvestmentTransaction(props: OwnerInvestmentTransactionProps) {
  return (
      <AmountInput label="3. ¿Cuánto invirtió el dueño en el negocio?" amountValue={props.transaction?.amount ?? 0}
                   onAmountChangedEvent={props.onValueChange}/>
  );
}

export default OwnerInvestmentTransaction;
