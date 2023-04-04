import {TrialBalance} from "../exercises/models/solved-exercise.model";

interface TrialBalanceTableProps {
  trialBalance: TrialBalance | undefined;
}

function TrialBalanceTable(props: TrialBalanceTableProps) {
  const formatCurrency = (value: number | undefined) => {
    return value?.toLocaleString('en-US', {style: 'currency', currency: 'USD'});
  };

  return (
      <section className="p-datatable p-component p-datatable-striped">
        <table>
          <thead className="p-datatable-thead">
          <tr>
            <th>Cuenta</th>
            <th>Débito</th>
            <th>Crédito</th>
          </tr>
          </thead>
          <tbody className="p-datatable-tbody">
          {
            props.trialBalance?.entries.map(entry => {
              return (
                  <>
                    <tr className={'p-row-odd'}>
                      <td>{entry.accountName}</td>
                      <td>{formatCurrency(entry.debit)}</td>
                      <td>{formatCurrency(entry.credit)}</td>
                    </tr>
                  </>
              )
            })
          }
          <tr>
            <td>Total</td>
            <td>{formatCurrency(props.trialBalance?.totalDebit)}</td>
            <td>{formatCurrency(props.trialBalance?.totalCredit)}</td>
          </tr>
          </tbody>
        </table>
      </section>
  );
}

export default TrialBalanceTable;