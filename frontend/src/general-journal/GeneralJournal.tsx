
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { PrimeIcons } from 'primereact/api';
import React from 'react';

export class DiarioGeneralModel {
  fecha: string;
  cuenta: string;
  descripcion: string;
  debe: number;
  haber: number;
}



function DiarioGeneral() {

  const data: DiarioGeneralModel[] =
  [
    {
      fecha: '01/01/2022',
      cuenta: 'Caja',
      descripcion: 'Pago de sueldos',
      debe: 2000,
      haber: 0
    },
    {
      fecha: '01/01/2022',
      cuenta: 'Sueldos a pagar',
      descripcion: 'Pago de sueldos',
      debe: 0,
      haber: 2000
    },

  ];

  return (
    <DataTable value={data}>
      <Column field="fecha" header="Fecha" />
      <Column field="cuenta" header="Cuenta" />
      <Column field="descripcion" header="Descripción" />
      <Column field="debe" header="Debe" />
      <Column field="haber" header="Haber" />
      <Column
        body={() => (
          <div className="p-d-flex p-flex-row p-justify-center">
            <i className={PrimeIcons.PENCIL} />
            <i className={PrimeIcons.TRASH} />
          </div>
        )}
      />
    </DataTable>
  );
}

export default DiarioGeneral;
