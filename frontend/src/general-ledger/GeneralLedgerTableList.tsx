import {
  GeneralJournalEntry,
  GeneralJournalRow,
  GeneralLedger,
  GeneralLedgerAccount, GeneralLedgerEntry
} from "../exercises/models/solved-exercise.model";
import {DataTable} from "primereact/datatable";
import {Column} from "primereact/column";


interface GeneralLedgerTableProps {
  account: GeneralLedgerAccount;
}

function GeneralLedgerTable(props: GeneralLedgerTableProps) {

  const header = (
      <div className="flex flex-wrap align-items-center justify-content-between gap-2">
        <span className="text-xl text-900 font-bold">Número de cuenta: {props.account.account}</span>
      </div>
  );

  if (props.account.entries.length === 0) {
    return (
        <></>
    );
  }

  const formatCurrency = (value: number) => {
    return value.toLocaleString('en-US', {style: 'currency', currency: 'USD'});
  };

  const debitTemplate = (row: GeneralLedgerEntry) => {
    return formatCurrency(row.debit);
  };

  const creditTemplate = (row: GeneralLedgerEntry) => {
    return formatCurrency(row.credit);
  };

  const valueTemplate = (row: GeneralLedgerEntry) => {
    if(row.value === undefined) {
      return '';
    }
    return formatCurrency(row.value);
  };

  return (
      <>
        <DataTable header={header} className={'mb-5'} value={props.account.entries}>
          <Column field='date' header='Fecha'/>
          <Column field='debit' header='Débito' body={debitTemplate}/>
          <Column field='credit' header='Crédito' body={creditTemplate}/>
          <Column field='value' header='Saldo' body={valueTemplate}/>
        </DataTable>
      </>
  );
}


interface GeneralLedgerTableListProps {
  generalLedger?: GeneralLedger
}

function GeneralLedgerTableList(props: GeneralLedgerTableListProps) {
  return (
      <section>
        {
          props.generalLedger?.entriesPerAccount.map(account => {
            return (
                <>
                  <GeneralLedgerTable key={account.account} account={account}/>
                </>
            );
          })
        }
      </section>
  )
}

export default GeneralLedgerTableList;