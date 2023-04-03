import {ExerciseFormRequestModel} from "../models/exercise-form-request.model";
import {SolvedExerciseModel} from "../models/solved-exercise.model";
import axios, {AxiosResponse} from "axios";

async function solveExercise(data: ExerciseFormRequestModel): Promise<SolvedExerciseModel> {
  const solvedExercise = await axios.post<SolvedExerciseModel>('http://localhost:7000/solve-exercise', data);
  return solvedExercise.data;
}

async function getSolvedExercise(id: string | undefined): Promise<SolvedExerciseModel> {
  const solvedExercise = await axios.get<SolvedExerciseModel>(`http://localhost:7000/solved-exercise/${id}`);
  return solvedExercise.data;
}

async function getSolvedExercisePdf(id: string): Promise<AxiosResponse> {
  return await axios.get(`http://localhost:7000/solved-exercise/${id}`, {responseType: 'blob'});
}

export {solveExercise, getSolvedExercisePdf, getSolvedExercise};