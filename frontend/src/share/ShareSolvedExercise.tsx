import {SolvedExerciseModel} from "../exercises/models/solved-exercise.model";
import React from "react";
import {Button} from "primereact/button";
import {useQuery} from "react-query";
import * as ExerciseService from "../exercises/services/exercise.service";

interface ShareSolvedExerciseProps {
  solvedExercise?: SolvedExerciseModel;
}

function ShareSolvedExercise(props: ShareSolvedExerciseProps) {

  const {
    data : httpResponse,
    isError,
    error,
    isLoading
  } = useQuery(['solvedExercisePdf', {id: props.solvedExercise?.id}], () => ExerciseService.getSolvedExercisePdf(props.solvedExercise?.id));

  const exportSolvedExerciseToPdf =  () => {
    const pdfUrl = window.URL.createObjectURL(httpResponse?.data);
    window.open(pdfUrl);
    setTimeout(() => window.URL.revokeObjectURL(pdfUrl), 100);
  }

  return (
      <section className={'share-exercise-section mt-5 p-component'}>
        <Button severity="danger" label="Exportar como PDF" icon="pi pi-file-pdf" loading={isLoading} onClick={exportSolvedExerciseToPdf} />
      </section>
  );
}

export default ShareSolvedExercise;