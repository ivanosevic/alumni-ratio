import {useLocation} from "react-router-dom";
import {ExerciseFormRequestModel} from "./models/exercise-form-request.model";
import {useMutation} from "react-query";
import React, {useEffect, useState} from "react";
import {SolvedExerciseModel} from "./models/solved-exercise.model";
import {ProgressSpinner} from "primereact/progressspinner";

function SolvedExercisePage() {
  const [solvedExercise, setSolvedExercise] = useState<SolvedExerciseModel>();

  /*
  Up to this point, this means that the data we pass through
  the form component hasn't come, so we cannot send the request
  to solve the exercise at this moment.
 */
  const location = useLocation();
  const data: ExerciseFormRequestModel = location.state?.data as ExerciseFormRequestModel;
  if (data === undefined || data === null) {
    return (
        <>
          <p>Data is null</p>
        </>
    );
  }

  const solveExercise = async () => {
    const response: Response = await fetch('http://localhost:7000/solve-exercise', {
      method: 'POST',
      body: JSON.stringify(data)
    });
    const dataFromServer: SolvedExerciseModel = await response.json();
    setSolvedExercise(dataFromServer);
  };

  const {isLoading, isError, error, mutate} = useMutation(solveExercise);

  useEffect(() => {
    mutate();
  }, []);


  if (isLoading) {
    return (
        <section className="flex flex-wrap justify-content-center">
          <ProgressSpinner style={{width: '50px', height: '50px'}} strokeWidth="8" fill="var(--surface-ground)"
                           animationDuration=".5s"/>
        </section>
    );
  }

  if (!isLoading && isError) {
    return (
        <>
          <p>Error getting the data.</p>
          <p>{JSON.stringify(error)}</p>
        </>
    );
  }

  console.log(solvedExercise);
  return (
      <>
        <p>I am here!</p>
        {JSON.stringify(solvedExercise)}
      </>
  );
}

export default SolvedExercisePage;