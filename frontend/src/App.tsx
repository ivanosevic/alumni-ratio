import React, {useState} from "react";
import GeneralJournal, { GeneralJournalModel } from "./general-journal/GeneralJournal";
import DiarioGeneral from "./general-journal/GeneralJournal";
import {Transaction} from "./transactions/models/transaction.model";
import TransactionComponent from "./transactions/TransactionComponent";

function App() {
    const [transaction, setTransaction] = useState<Transaction>();
    
    const data: GeneralJournalModel[] = [
        {
          date: '01/01/2022',
          account: 'Cash',
          reference: '1010-3',
          debit: 2000,
        },
        {
          account: 'Salaries Payable',
          reference: '3010-1',
          credit: 2000,
        },
      ];
    return (
        <>
            <GeneralJournal generalJournalData={data}/>
        </>
    );
}

export default App;
