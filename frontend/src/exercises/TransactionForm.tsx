import {Transaction} from "../transactions/models/transaction.model";
import React, {useState} from "react";
import {Button} from "primereact/button";
import TransactionComponent from "../transactions/TransactionComponent";

interface TransactionFormProps {
  transactions: Transaction[];
  setTransactions: React.Dispatch<React.SetStateAction<Transaction[]>>;
}

function TransactionForm(props: TransactionFormProps) {
  const addNewTransactions = () => {
    props.setTransactions(prevState => {
      return [...prevState, new Transaction()];
    })
  }
  return (
      <>
        <section>
          <TransactionComponent transactions={props.transactions} setTransactions={props.setTransactions}/>
        </section>

        <section className="transaction-controls flex flex-wrap align-items-center justify-content-center mb-5 mt-5">
          <Button severity="warning" rounded onClick={addNewTransactions}>Nueva Transacción</Button>
        </section>
      </>
  );
}

export default TransactionForm;