import React, {useState} from "react";
import {Transaction} from "./transactions/models/transaction.model";
import TransactionComponent from "./transactions/TransactionComponent";
import ExerciseForm from "./transactions/ExerciseForm";

function App() {
    const [transaction, setTransaction] = useState<Transaction>();
    return (
        <>
            <ExerciseForm />
            <TransactionComponent transaction={transaction} setTransaction={setTransaction} />
        </>
    );
}

export default App;
