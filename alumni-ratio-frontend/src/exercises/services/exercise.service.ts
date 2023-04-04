import {ExerciseFormRequestModel} from "../models/exercise-form-request.model";
import {SolvedExerciseModel} from "../models/solved-exercise.model";
import axios, {AxiosResponse} from "axios";

async function solveExercise(data: ExerciseFormRequestModel): Promise<SolvedExerciseModel> {
  const solvedExercise = await axios.post<SolvedExerciseModel>(`${import.meta.env.VITE_ALUMNI_RATIO_API_URL}/solve-exercise`, data);
  return solvedExercise.data;
}

async function getSolvedExercise(id: string | undefined): Promise<SolvedExerciseModel> {
  const solvedExercise = await axios.get<SolvedExerciseModel>(`${import.meta.env.VITE_ALUMNI_RATIO_API_URL}/solved-exercise/${id}`);
  return solvedExercise.data;
}

async function getSolvedExercisePdf(id: string | undefined): Promise<AxiosResponse> {
  return await axios.get(`${import.meta.env.VITE_ALUMNI_RATIO_API_URL}/solved-exercise/${id}/pdf`, {responseType: 'blob'});
}

export {solveExercise, getSolvedExercisePdf, getSolvedExercise};