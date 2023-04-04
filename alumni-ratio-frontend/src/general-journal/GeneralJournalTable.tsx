import {GeneralJournal, GeneralJournalEntry, GeneralJournalRow} from "../exercises/models/solved-exercise.model";

interface DetailFieldRowProps {
  row: GeneralJournalRow;
}

function DetailFieldRow(props: DetailFieldRowProps) {
  return (
      <>
        {props.row.debit > 0 ? <td>{props.row.detail}</td> : <td><span>&nbsp;&nbsp;</span>{props.row.detail}</td>}
      </>
  )
}

interface DateFieldRowProps {
  row: GeneralJournalRow;
  index: number
}

function DateFieldRow(props: DateFieldRowProps) {
  return (
      <>
        {props.index == 0 ? <td>{new Date(props.row.date).toLocaleDateString()}</td> : <td><span>&nbsp;</span></td>}
      </>
  )
}

interface GeneralJournalTableProps {
  data: GeneralJournal | undefined;
  companyName: string | undefined;
}

function GeneralJournalTable(props: GeneralJournalTableProps) {
  const columns = [
    {field: 'date', header: 'Code'},
    {field: 'reference', header: 'Reference'},
    {field: 'detail', header: 'Reference'},
    {field: 'debit', header: 'Debit'},
    {field: 'credit', header: 'Credit'}
  ];

  const formatCurrency = (value: number) => {
    return value.toLocaleString('en-US', { style: 'currency', currency: 'USD' });
  };

  return (
      <section className="p-datatable p-component p-datatable-striped">
        <table>
          <thead className="p-datatable-thead">
          <tr>
            <th className="text-center" colSpan={columns.length}>{props.companyName}</th>
          </tr>
          <tr>
            <th className="text-center" colSpan={columns.length}>Diario General</th>
          </tr>
          <tr>
            <th>Fecha</th>
            <th>Detalle</th>
            <th>Referencia</th>
            <th>Débito</th>
            <th>Crédito</th>
          </tr>
          </thead>
          <tbody className="p-datatable-tbody">
          {
            props.data?.generalJournalEntries.map(entry => {
              return (
                  <>
                    {
                      entry.generalJournalRows.map((row, j) => {
                        return (
                            <tr className={'p-row-odd'}>
                              <DateFieldRow row={row} index={j} />
                              <DetailFieldRow row={row}></DetailFieldRow>
                              <td>{row.reference}</td>
                              <td>{formatCurrency(row.debit)}</td>
                              <td>{formatCurrency(row.credit)}</td>
                            </tr>
                        );
                      })
                    }
                    <tr>
                      <td colSpan={columns.length}>{entry.explanation}</td>
                    </tr>
                  </>
              )
            })
          }
          </tbody>
        </table>
      </section>
  );
}


export default GeneralJournalTable;