import {useState} from "react";
import ExerciseForm, {ExerciseFormModel} from "./ExerciseForm";
import {Card} from "primereact/card";

function AccountingExerciseForm() {
  const [exerciseFormModel, setExerciseFormModel] = useState<ExerciseFormModel>(new ExerciseFormModel());

  return (
      <>
        <Card title={'Exercise Form'}>
          <ExerciseForm exerciseForm={exerciseFormModel} setExerciseFormModel={setExerciseFormModel} />
        </Card>
      </>
  )
}

export default AccountingExerciseForm;