import React, {useState} from "react";
import ExerciseForm, {ExerciseFormModel} from "./ExerciseForm";
import {Steps, StepsSelectEvent} from "primereact/steps";
import {MenuItem} from "primereact/menuitem";
import {Card} from "primereact/card";
import {Transaction} from "../transactions/models/transaction.model";
import TransactionForm from "./TransactionForm";
import {Button} from "primereact/button";
import ConfirmExercise from "./ConfirmExercise";
import {useMutation, useQueryClient} from "react-query";
import * as ExerciseService from "./services/exercise.service";
import {useNavigate} from "react-router-dom";
import {Dialog} from "primereact/dialog";
import {ProgressSpinner} from "primereact/progressspinner";
import {ExerciseFormRequestModel} from "./models/exercise-form-request.model";
import {SolvedExerciseModel} from "./models/solved-exercise.model";

function AccountingExerciseForm() {
  const reactQueryClient = useQueryClient();
  const navigate = useNavigate();
  const [resultsPanelVisibility, setResultsPanelVisibility] = useState<boolean>(true);
  const {isLoading, isError, error, mutate} = useMutation(ExerciseService.solveExercise);
  const [transactions, setTransactions] = useState<Transaction[]>([new Transaction()]);
  const [activeStepItemIndex, setActiveStepItemIndex] = useState(0);
  const [exerciseFormModel, setExerciseFormModel] = useState<ExerciseFormModel>({
    yearOperations: new Date().getFullYear(),
    requiresAssistance: false,
    ownerName: '',
    companyName: '',
    monthOperations: new Date().getMonth()
  });

  const items: MenuItem[] = [
    {
      label: 'Informaciones Generales'
    },
    {
      label: 'Transacciones'
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

  const submitExercise = () => {
    setResultsPanelVisibility(true);

    const exerciseFormRequest: ExerciseFormRequestModel = {
      companyName: exerciseFormModel.companyName,
      companyOwner: exerciseFormModel.ownerName,
      requiresAssistance: exerciseFormModel.requiresAssistance,
      monthOperations: exerciseFormModel.monthOperations,
      yearOperations: exerciseFormModel.yearOperations,
      transactions: transactions
    };

    mutate(exerciseFormRequest, {
      onSuccess: (data: SolvedExerciseModel) => {
        reactQueryClient.setQueryData(['solvedExercise', {id: data.id}], data);
        const url = `/solved-exercise/${data.id}`;
        navigate(url);
      }
    });
  }

  const formFooter = () => {
    return (
        <>
          <div className="flex flex-wrap align-items-center justify-content-between gap-2">
            <Button label={'Atrás'} disabled={canGoPrevious()} onClick={goBackToPreviousStep} raised/>
            {activeStepItemIndex === 1 ?
                <ConfirmExercise transactions={transactions} exerciseFormModel={exerciseFormModel}
                                 onAcceptDialog={submitExercise}/> :
                <Button label={'Siguiente'} disabled={canGoNext()} onClick={goNextStep} raised/>}

          </div>
        </>
    );
  };

  const WaitingForServerToSolveExercise = () => {
    return (
        <>
          <Dialog header={'Resolviendo ejercicio'} draggable={false} closable={false}
                  onHide={() => setResultsPanelVisibility(false)}
                  visible={resultsPanelVisibility}>
            <section className="flex flex-wrap justify-content-center">
              <ProgressSpinner style={{width: '50px', height: '50px'}} strokeWidth="8" fill="var(--surface-ground)"
                               animationDuration=".5s"/>
            </section>
          </Dialog>
        </>
    )
  }

  const ErrorWhileSolvingExercise = () => {
    return (
        <>
          <Dialog header={'Ocurrió un problema'} draggable={false} closable={true}
                  onHide={() => setResultsPanelVisibility(false)}
                  visible={resultsPanelVisibility}>
            <section className="flex flex-wrap justify-content-center">
              <p>Ocurrió un error al tratar de resolver el ejercicio. Por favor, intentelo más tarde. Si el error
                persiste, por favor contactar a soporte.</p>
            </section>
          </Dialog>
        </>
    );
  }


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

          {isLoading ? <WaitingForServerToSolveExercise/> : null}
          {!isLoading && isError ? <ErrorWhileSolvingExercise/> : null}
        </Card>
      </>
  );
}

export default AccountingExerciseForm;