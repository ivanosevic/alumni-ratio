import {Transaction} from "../transactions/models/transaction.model";
import React, {useState} from "react";
import {Button} from "primereact/button";
import TransactionComponent from "../transactions/TransactionComponent";

interface TransactionFormProps {
  transactions: Transaction[];
  setTransactions: React.Dispatch<React.SetStateAction<Transaction[]>>;
}

function TransactionForm(props: TransactionFormProps) {
  const [activeTransactionIndex, setActiveTransactionIndex] = useState<number>(0);
  const [transactionRef, setTransactionRef] = useState<Transaction>(props.transactions[0]);

  const canGoPrevious = () => {
    return props.transactions.length >= 0;
  }

  const canGoNext = () => {
    return false;
  }

  const goBackToPreviousStep = () => {
    // The previous transaction will be our active transaction
    setActiveTransactionIndex(activeTransactionIndex - 1);

    // Reference it through the array
    setTransactionRef(props.transactions[activeTransactionIndex]);
  }

  const goNextStep = () => {
    // Set old data
    console.log(transactionRef);
    const temporaryTransactions = [...props.transactions];
    temporaryTransactions[activeTransactionIndex] = transactionRef;
    props.setTransactions(temporaryTransactions);

    // Let's push a new transaction.
    const newTransaction = new Transaction();
    props.setTransactions(prevState => [...prevState, newTransaction]);
    setActiveTransactionIndex(activeTransactionIndex + 1);

    // Now, the transaction that we are going to reference will be the new one.
    setTransactionRef(props.transactions[activeTransactionIndex]);
  }

  return (
      <>
        <section className="transaction-controls flex flex-wrap align-items-center justify-content-between gap-2 mb-5">
          <Button severity="info" rounded className="pi pi-angle-left" disabled={canGoPrevious()}
                  onClick={goBackToPreviousStep}></Button>
          <Button severity="info" rounded className="pi pi-angle-right" disabled={canGoNext()}
                  onClick={goNextStep}></Button>
        </section>

        <section>
          <TransactionComponent transaction={transactionRef} setTransaction={setTransactionRef}/>
        </section>
      </>
  );
}

export default TransactionForm;