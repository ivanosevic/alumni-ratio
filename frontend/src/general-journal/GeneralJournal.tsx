import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { PrimeIcons } from 'primereact/api';
import React, { useState } from 'react';

export class GeneralJournalModel {
  date?: string;
  account?: string;
  reference?: string;
  debit?: number;
  credit?: number;
  description?: string;
}

interface GeneralJournalProps{
generalJournalData: GeneralJournalModel[];
}

function GeneralJournal(props : GeneralJournalProps) {
  const [description, setDescription] = useState('');

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
  <div className="p-d-flex p-flex-column">
    <div className="p-d-flex p-flex-row p-justify-center p-align-center" style={{ marginBottom: '20px' }}>
      <h1 style={{ fontSize: '2.5rem' }}>Company Name</h1>
    </div>

    <div className="p-d-flex p-flex-row p-justify-between p-ai-center" style={{ marginBottom: '20px' }}>
      <h2 style={{ fontSize: '1.5rem' }}>General Journal</h2>
      <div className="p-d-flex p-flex-row-reverse p-ai-center">
        <span>Journal Page:</span>
        <input type="number" min="1" defaultValue="1" style={{ width: '30px' }}/>
      </div>
    </div>

    <div className="p-d-flex p-flex-row">
      <div className="p-d-flex p-flex-column" style={{ marginBottom: '20px', marginRight: '20px' }}>
        <DataTable value={props.generalJournalData} className="p-datatable-sm">
          <Column field="date" header="Date" />
          <Column field="account" header="Account" />
          <Column field="reference" header="Reference" />
          <Column field="debit" header="Debit" />
          <Column field="credit" header="Credit" />
        </DataTable>
      </div>

      <div className="p-d-flex p-flex-column" style={{ marginTop: '20px', fontWeight: 'bold' }}>
        <div>Description:</div>
        <input type="text" value={description} onChange={(e) => setDescription(e.target.value)} className="p-inputtext-sm" style={{ width: '600px' }} />
      </div>
    </div>
  </div>
);
}

export default GeneralJournal;