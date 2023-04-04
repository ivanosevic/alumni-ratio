import {useParams} from "react-router-dom";
import {useQuery} from "react-query";
import React, {useState} from "react";
import {ProgressSpinner} from "primereact/progressspinner";
import * as ExerciseService from "../exercises/services/exercise.service";
import {TabMenu} from "primereact/tabmenu";
import GeneralJournalTable from "../general-journal/GeneralJournalTable";
import GeneralLedgerTableList from "../general-ledger/GeneralLedgerTableList";
import ShareSolvedExercise from "../share/ShareSolvedExercise";
import TrialBalanceTable from "../trial-balance/TrialBalanceTable";

function SolvedExercisePage() {
  const {solvedExerciseId} = useParams();
  const {
    data,
    isError,
    error,
    isLoading
  } = useQuery(['solvedExercise', {id: solvedExerciseId}], () => ExerciseService.getSolvedExercise(solvedExerciseId));
  const [activeIndex, setActiveIndex] = useState<number>(0);
  const items = [
    {label: 'Diario General', icon: 'pi pi-fw pi-home'},
    {label: 'Mayor General', icon: 'pi pi-fw pi-calendar'},
    {label: 'Balanza de comprobación', icon: 'pi pi-fw pi-pencil'},
    {label: 'Compartir Ejercicio', icon: 'pi pi-share-alt'}
  ];

  console.log(data);

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

  return (
      <div className="card">
        <TabMenu model={items} activeIndex={activeIndex} onTabChange={(e) => setActiveIndex(e.index)}/>

        {activeIndex === 0 ?
            <GeneralJournalTable data={data?.generalJournal} companyName={data?.exercise.companyName}/> : null}

        {activeIndex === 1 ?
            <GeneralLedgerTableList generalLedger={data?.generalLedger}/> : null}

        {activeIndex === 2 ?
            <TrialBalanceTable companyName={data?.exercise.companyName} trialBalance={data?.trialBalance}/> : null}

        {activeIndex === 3 ? <ShareSolvedExercise solvedExercise={data}/> : null}
      </div>
  );
}

export default SolvedExercisePage;