import React from "react";
import ReactDOM from "react-dom/client";
import "primereact/resources/themes/lara-light-indigo/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primeflex/primeflex.min.css"
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import AccountingExerciseForm from "./exercises/AccountingExerciseForm";
import SolvedExercise from "./solutions/SolvedExercise";

const router = createBrowserRouter([
  {
    path: "/",
    element: <AccountingExerciseForm/>
  },
  {
    path: "/solved-exercise",
    element: <SolvedExercise/>
  }
])

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
    <React.StrictMode>
      <RouterProvider router={router} />
    </React.StrictMode>
);
