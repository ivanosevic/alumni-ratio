import React, {useState} from "react";
import {Transaction} from "./transactions/models/transaction.model";
import TransactionComponent from "./transactions/TransactionComponent";

function App() {
    const [transaction, setTransaction] = useState<Transaction>();
    return (
        <>
            <TransactionComponent transaction={transaction} setTransaction={setTransaction} />
        </>
    );
}

export default App;
