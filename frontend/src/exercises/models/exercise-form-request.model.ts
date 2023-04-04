import {ExerciseFormModel} from "../ExerciseForm";
import {Transaction} from "../../transactions/models/transaction.model";

export interface ExerciseFormRequestModel {
  companyName: string;
  companyOwner: string;
  requiresAssistance: boolean;
  monthOperations: number;
  yearOperations: number;
  transactions: Transaction[];
}