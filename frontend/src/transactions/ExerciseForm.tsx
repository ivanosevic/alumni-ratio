import React, {ChangeEventHandler, useState} from "react";
import {InputText} from "primereact/inputtext";

export class ExerciseFormModel {
    companyName?: string;
    ownerName?: string;
    initialOperationDate?: Date;
    requiresAssistance?: boolean;
}

function ExerciseForm() {
    const [exerciseFormModel, setExerciseFormModel] = useState<ExerciseFormModel>(new ExerciseFormModel());

    const onCompanyNameValueChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setExerciseFormModel(prevState => {
            return {
                ...prevState,
                companyName: e.target.value
            }
        });
    }

    return (
        <>
            <div className="formgrid grid">
                <section className="col-12">
                    <div className="field">
                        <label className="text-base">
                            Company name
                        </label>
                        <div className="col">
                            <InputText value={exerciseFormModel?.companyName} onChange={onCompanyNameValueChange}/>
                        </div>
                    </div>
                </section>
            </div>
        </>
    )
}

export default ExerciseForm;