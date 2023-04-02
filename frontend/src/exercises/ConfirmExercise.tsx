import {Transaction} from "../transactions/models/transaction.model";
import {ExerciseFormModel} from "./ExerciseForm";
import {Button} from "primereact/button";
import React from "react";
import {confirmDialog, ConfirmDialog} from "primereact/confirmdialog";

interface ConfirmExerciseProps {
  transactions: Transaction[];
  exerciseFormModel: ExerciseFormModel;
}

function ConfirmExercise(props: ConfirmExerciseProps) {
  const acceptAndSolveExercise = () => {
    console.log('Sending to other react view.')
  }

  const confirmationModal = () => {
    confirmDialog({
      message: 'Hemos capturado todos los datos del ejercicio. ¿Está seguro de que quiere subir lo que tiene hasta el momento? Presione el botón más abajo para obtener la respuesta del ejercicio.',
      header: 'Confirmación de datos',
      icon: 'pi pi-exclamation-triangle',
      accept: acceptAndSolveExercise,
      acceptLabel: 'Si',
      rejectLabel: 'No'
    });
  };
  return (
      <>
        <div className="flex flex-wrap justify-content-center mt-5">
          <ConfirmDialog/>
          <div className="card flex flex-wrap gap-2 justify-content-center">
            <Button severity="info" onClick={confirmationModal}>Resolver ejercicio</Button>
          </div>
        </div>
      </>
  );
}

export default ConfirmExercise;