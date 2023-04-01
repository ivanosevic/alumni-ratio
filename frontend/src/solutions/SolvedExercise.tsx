import React, {useState} from "react";
import {TabMenu} from "primereact/tabmenu";

function SolvedExercise() {
  const [activeIndex, setActiveIndex] = useState<number>(0);
  const items = [
    {label: 'Diario General', icon: 'pi pi-fw pi-home'},
    {label: 'Mayor General', icon: 'pi pi-fw pi-calendar'},
    {label: 'Balanza de comprobación', icon: 'pi pi-fw pi-pencil'}
  ];

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

export default SolvedExercise;