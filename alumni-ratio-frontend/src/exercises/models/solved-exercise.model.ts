import {ExerciseFormModel} from "../ExerciseForm";
import {Transaction} from "../../transactions/models/transaction.model";

export interface GeneralJournalRow {
  date: Date;
  reference: number;
  detail: string;
  debit: number;
  credit: number;
}

export interface GeneralJournalEntry {
  date: Date;
  explanation: string;
  generalJournalRows: GeneralJournalRow[]
}

export interface GeneralJournal {
  generalJournalEntries: GeneralJournalEntry[];
}

export interface GeneralLedgerEntry {
  date: number;
  reference: number;
  debit: number;
  credit: number;
  value: number;
}

export interface GeneralLedgerAccount {
  account: number;
  entries: GeneralJournalEntry[];
}

export interface GeneralLedger {
  entriesPerAccount: GeneralLedgerAccount[];
}

export interface TrialBalanceEntry {
  accountName: string;
  debit: number;
  credit: number;
}

export interface TrialBalance {
  id: string;
  entries: TrialBalanceEntry[]
  totalDebit: number;
  totalCredit: number;
}

export interface SolvedExerciseModel {
  id: string;
  exercise: ExerciseFormModel;
  transactions: Transaction[];
  generalLedger: GeneralLedger;
  generalJournal: GeneralJournal;
  trialBalance: TrialBalance;
}