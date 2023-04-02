import {Transaction} from "../transactions/models/transaction.model";
import React, {useState} from "react";
import {Button} from "primereact/button";
import TransactionComponent from "../transactions/TransactionComponent";

interface TransactionFormProps {
  transactions: Transaction[];
  setTransactions: React.Dispatch<React.SetStateAction<Transaction[]>>;
}

function TransactionForm(props: TransactionFormProps) {
  return (
      <>
        <section className="transaction-controls flex flex-wrap align-items-center justify-content-end mb-5">
          <Button severity="info" rounded className="pi pi-plus">Nueva Transacción</Button>
        </section>

        <section>
          <TransactionComponent transactions={props.transactions} setTransactions={props.setTransactions}/>
        </section>
      </>
  );
}

export default TransactionForm;