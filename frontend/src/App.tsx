import React, {useState} from "react";
import GeneralJournal from "./general-journal/GeneralJournal";
import DiarioGeneral from "./general-journal/GeneralJournal";
import {Transaction} from "./transactions/models/transaction.model";
import TransactionComponent from "./transactions/TransactionComponent";

function App() {
    const [transaction, setTransaction] = useState<Transaction>();
    return (
        <>
            <GeneralJournal/>
        </>
    );
}

export default App;
