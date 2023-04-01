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

  return (
      <>
        <section className="transaction-controls flex flex-wrap align-items-center justify-content-between gap-2 mb-5">
          <Button severity="info" rounded className="pi pi-plus"></Button>
        </section>

        <section>
          <TransactionComponent transactions={props.transactions} setTransactions={props.setTransactions}/>
        </section>
      </>
  );
}

export default TransactionForm;