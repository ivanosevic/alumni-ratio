import React, {useState} from "react";
import ExerciseForm, {ExerciseFormModel} from "./ExerciseForm";
import {Steps, StepsSelectEvent} from "primereact/steps";
import {MenuItem} from "primereact/menuitem";
import {Card} from "primereact/card";

function AccountingExerciseForm() {
  const [exerciseFormModel, setExerciseFormModel] = useState<ExerciseFormModel>(new ExerciseFormModel());
  const [activeIndex, setActiveIndex] = useState(0);
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

  return (
      <>
        <Card>
          <Steps className="mb-5" model={items} activeIndex={activeIndex}
                 onSelect={(e: StepsSelectEvent) => setActiveIndex(e.index)}
                 readOnly={true}/>

          <section className="active-section">
            {activeIndex === 0 ?
                <ExerciseForm exerciseForm={exerciseFormModel} setExerciseFormModel={setExerciseFormModel}/> : null}
          </section>
        </Card>
      </>
  )
}

export default AccountingExerciseForm;