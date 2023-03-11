import React from "react";
import {InputText} from "primereact/inputtext";
import {InputNumber, InputNumberValueChangeEvent} from 'primereact/inputnumber';
import {Checkbox, CheckboxChangeEvent} from "primereact/checkbox";


export class ExerciseFormModel {
  companyName?: string;
  ownerName?: string;
  requiresAssistance: boolean = false;
  monthOperations?: number;
  yearOperations?: number;
}

interface ExerciseFormProp {
  exerciseForm: ExerciseFormModel;
  setExerciseFormModel: React.Dispatch<React.SetStateAction<ExerciseFormModel>>;
}

function ExerciseForm(props: ExerciseFormProp) {


  const onCompanyNameValueChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    props.setExerciseFormModel(prevState => {
      return {
        ...prevState,
        companyName: e.target.value
      }
    });

  }
  const onOwnerNameValueChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    props.setExerciseFormModel(prevState => {
      return {
        ...prevState,
        ownerName: e.target.value
      }
    });
  }

  const onYearsOfOperationValueChange = (e: InputNumberValueChangeEvent) => {
    props.setExerciseFormModel(prevState => {
      return {
        ...prevState,
        yearOperations: e.target.value ?? 1
      }
    });
  }

  const onMonthOfOperationValueChange = (e: InputNumberValueChangeEvent) => {
    props.setExerciseFormModel(prevState => {
      return {
        ...prevState,
        monthOperations: e.target.value ?? 1
      }
    });
  }

  const requestAssistanceValueChange = (e: CheckboxChangeEvent) => {
    props.setExerciseFormModel(prevState => {
      return {
        ...prevState,
        requiresAssistance: e.checked ?? false
      }
    });
  }

  return (
      <>
        <div className="formgrid grid">
          <div className="field col">
            <label htmlFor="companyName">Company Name</label>
            <InputText id="companyName"
                       className="text-base text-color surface-overlay p-2 border-1 border-solid surface-border border-round appearance-none outline-none focus:border-primary w-full"
                       value={props.exerciseForm?.companyName} onChange={onCompanyNameValueChange}/>
          </div>
        </div>
        <div className="formgrid grid">
          <div className="field col">
            <label htmlFor="companyOwner">Company Owner</label>
            <InputText id="companyOwner"
                       className="text-base text-color surface-overlay p-2 border-1 border-solid surface-border border-round appearance-none outline-none focus:border-primary w-full"
                       value={props.exerciseForm?.ownerName} onChange={onOwnerNameValueChange}/>
          </div>
        </div>
        <div className="formgrid grid">
          <div className="field col">
            <label htmlFor="monthOperations">Month of Operations</label>
            <InputNumber id="monthOperations"
                         className="text-base text-color p-0.5 appearance-none outline-none focus:border-primary w-full"
                         value={props.exerciseForm?.monthOperations} onValueChange={onMonthOfOperationValueChange}
                         min={1} max={12}/>
          </div>
        </div>
        <div className="formgrid grid">
          <div className="field col">
            <label htmlFor="yearOperations">Year of Operations</label>
            <InputNumber id="yearOperations"
                         className="text-base text-color p-0.5 border-round appearance-none outline-none focus:border-primary w-full"
                         value={props.exerciseForm?.yearOperations} onValueChange={onYearsOfOperationValueChange}
                         min={1900} max={2100}/>
          </div>
        </div>
        <div className="formgroup-inline">
          <div className="field-checkbox">
            <Checkbox checked={props.exerciseForm.requiresAssistance} onChange={requestAssistanceValueChange}/>
            <label htmlFor="yearOperations">Do you want the application to give you a guide through solving the
              exercise?</label>
          </div>
        </div>
      </>
  )
}

export default ExerciseForm;