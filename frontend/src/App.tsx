import React, {useState} from "react";
import {Transaction} from "./transactions/models/transaction.model";
import AccountingExerciseForm from "./exercises/AccountingExerciseForm";

function App() {
    const [transaction, setTransaction] = useState<Transaction>();
    return (
        <>
            <AccountingExerciseForm />
        </>
    );
}

export default App;
