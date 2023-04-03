import {useParams} from "react-router-dom";
import {useQuery} from "react-query";
import React, {useState} from "react";
import {ProgressSpinner} from "primereact/progressspinner";
import * as ExerciseService from "../exercises/services/exercise.service";
import {TabMenu} from "primereact/tabmenu";

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
    {label: 'Balanza de comprobación', icon: 'pi pi-fw pi-pencil'}
  ];

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
            <p>Aqui se presenta el diario General</p> : null}

        {activeIndex === 1 ?
            <p>Aqui se presenta el mayor general</p> : null}

        {activeIndex === 2 ?
            <p>Aqui se presenta la balanza de comprobacion</p> : null}
      </div>
  );
}

export default SolvedExercisePage;