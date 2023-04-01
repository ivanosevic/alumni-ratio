import React, {useState} from "react";
import ExerciseForm, {ExerciseFormModel} from "./ExerciseForm";
import {Steps, StepsSelectEvent} from "primereact/steps";
import {MenuItem} from "primereact/menuitem";
import {Card} from "primereact/card";
import {Transaction} from "../transactions/models/transaction.model";
import TransactionForm from "./TransactionForm";
import {Button} from "primereact/button";


function AccountingExerciseForm() {
  const [transactions, setTransactions] = useState<Transaction[]>([new Transaction(), new Transaction()]);
  const [exerciseFormModel, setExerciseFormModel] = useState<ExerciseFormModel>(new ExerciseFormModel());
  const [activeStepItemIndex, setActiveStepItemIndex] = useState(0);
  const items: MenuItem[] = [
    {
      label: 'Informaciones Generales'
    },
    {
      label: 'Transacciones'
    },
    {
      label: 'Confirmación',
    }
  ];

  const canGoPrevious = () => {
    return !(activeStepItemIndex > 0);
  }

  const canGoNext = () => {
    return activeStepItemIndex + 1 >= items.length;
  }

  const goBackToPreviousStep = () => {
    setActiveStepItemIndex(activeStepItemIndex - 1);
  }

  const goNextStep = () => {
    setActiveStepItemIndex(activeStepItemIndex + 1);
  }

  const formFooter = () => {
    return (
        <>
          <div className="flex flex-wrap align-items-center justify-content-between gap-2">
            <Button label={'Atrás'} disabled={canGoPrevious()} onClick={goBackToPreviousStep} raised/>
            <Button label={'Siguiente'} disabled={canGoNext()} onClick={goNextStep} raised/>
          </div>
        </>
    );
  };

  return (
      <>
        <Card footer={formFooter}>
          <Steps className="mb-5" model={items} activeIndex={activeStepItemIndex}
                 onSelect={(e: StepsSelectEvent) => setActiveStepItemIndex(e.index)}
                 readOnly={true}/>

          <section className="active-section">
            {activeStepItemIndex === 0 ?
                <ExerciseForm exerciseForm={exerciseFormModel} setExerciseFormModel={setExerciseFormModel}/> : null}

            {activeStepItemIndex === 1 ?
                <TransactionForm setTransactions={setTransactions} transactions={transactions}/> : null}
          </section>
        </Card>
      </>
  );
}

export default AccountingExerciseForm;