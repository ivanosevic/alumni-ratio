import React, {ChangeEventHandler, useState} from "react";
import {InputText} from "primereact/inputtext";
import { Checkbox } from 'primereact/checkbox';
import { Calendar } from 'primereact/calendar';
import { addLocale } from 'primereact/api';
import { InputNumber } from 'primereact/inputnumber';


export class ExerciseFormModel {
    companyName?: string;
    ownerName?: string;
    initialOperationDate?: Date;
    requiresAssistance?: boolean;
    monthOperations?: number;
    yearOperations?: number;
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
    const onOwnerNameValueChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setExerciseFormModel(prevState => {
            return {
                ...prevState,
                ownerName: e.target.value
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
                        <p> </p>
                        <label className="text-base">
                            Company Owner
                        </label>
                        <div className="col">
                            <InputText value={exerciseFormModel?.ownerName} onChange={onOwnerNameValueChange}/>
                        </div>
                        <p> </p>

                        <label className="text-base">
                            Company Start of campaing month:
                            <InputNumber value={value4} onValueChange={(e) => setValue4(e.value)} min={1} max={12} />
                            <p> </p>
                            Company Start of campaing year:
                            <InputNumber value={value4} onValueChange={(e) => setValue4(e.value)} min={1900} max={2100} />

                        </label>
                        <p> </p>
                        <label className="text-base">
                            Do you require assitance:
                            
                        </label>
                        <div> </div>

                    </div>
                </section>
            </div>
        </>

        
    )
}

export default ExerciseForm;