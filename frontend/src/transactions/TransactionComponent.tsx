import {Transaction, TransactionType} from "./models/transaction.model";
import React, {useState} from "react";
import {Card} from "primereact/card";
import {Calendar, CalendarChangeEvent} from "primereact/calendar";
import {Dropdown} from "primereact/dropdown";
import OwnerInvestmentTransaction from "./types/OwnerInvestmentTransaction";
import OfficeSuppliesPurchaseTransaction from "./types/OfficeSuppliesPurchaseTransaction";
import LandPurchaseTransaction from "./types/LandPurchaseTransaction";
import {BankLoanTransaction} from "./types/BankLoanTransaction";
import ServiceRevenuesTransaction from "./types/ServiceRevenuesTransaction";
import PublicServicesExpensesTransaction from "./types/PublicServicesExpensesTransaction";
import RentExpensesTransaction from "./types/RentExpensesTransaction";
import WagesExpensesTransaction from "./types/WagesExpensesTransaction";

/**
 * This class is used when selecting the nature of the transaction on a dropdown.
 * The dropdown will show the label attribute, and the type will be attached so the enum
 * value is easier to retrieve.
 */
class TransactionTypeSelection {
    type?: TransactionType;
    label?: string;
}

interface TransactionComponentProps {
    transaction: Transaction;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction>>;
}

export default function TransactionComponent(props: TransactionComponentProps) {
    const [transactionTypeSelection, setTransactionTypeSelection] = useState<TransactionTypeSelection | null | undefined>();

    const transactionTypeSelections: TransactionTypeSelection[] = [
        {
            label: 'Inversión del dueño al negocio',
            type: TransactionType.OWNER_INVESTMENT
        },
        {
            label: 'Compra de materiales de oficina',
            type: TransactionType.OFFICE_SUPPLIES_PURCHASE
        },
        {
            label: 'Compra de equipos de oficina',
            type: TransactionType.OFFICE_EQUIPMENT_PURCHASE
        },
        {
            label: 'Compra de terreno',
            type: TransactionType.LAND_PURCHASE
        },
        {
            label: 'Préstamo Bancario',
            type: TransactionType.BANK_LOAN
        },
        {
            label: 'Ingresos por servicios',
            type: TransactionType.SERVICE_REVENUES
        },
        {
            label: 'Pago de renta',
            type: TransactionType.RENT_EXPENSES
        },
        {
            label: 'Pago de sueldos',
            type: TransactionType.WAGES_EXPENSES
        },
        {
            label: 'Pago de servicios públicos',
            type: TransactionType.PUBLIC_SERVICES_EXPENSES
        }
    ];

    const handleTransactionDageChange = (e: CalendarChangeEvent) => {
        props.setTransaction(prevState => {
            return {
                ...prevState,
                date: (e.value as Date)
            }
        });
    }

    return (
        <div className="formgrid grid">
            <section className="col-12">
                <div className="field">
                    <label>1. Selecciona la fecha de la transacción</label>
                    <div className="col">
                        <Calendar className="w-full md:w-5" value={props.transaction?.date}
                                  onChange={handleTransactionDageChange} showIcon/>
                    </div>
                </div>
            </section>
            <section className="col-12">
                <div className="field">
                    <label>2. ¿Qué clase de operación se realizó en esta transacción?</label>
                    <div className="col">
                        <Dropdown value={transactionTypeSelection}
                                  onChange={(e) => setTransactionTypeSelection(e.value)}
                                  options={transactionTypeSelections} optionLabel="label" className="w-full md:w-5"
                                  placeholder="Seleccione la operación realizada"/>
                    </div>
                </div>
            </section>
            <section className="col-12">
                {transactionTypeSelection?.type === TransactionType.OWNER_INVESTMENT ?
                    <OwnerInvestmentTransaction transaction={props.transaction}
                                                setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.OFFICE_SUPPLIES_PURCHASE ?
                    <OfficeSuppliesPurchaseTransaction transaction={props.transaction}
                                                       setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.OFFICE_EQUIPMENT_PURCHASE ?
                    <OfficeSuppliesPurchaseTransaction transaction={props.transaction}
                                                       setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.LAND_PURCHASE ?
                    <LandPurchaseTransaction transaction={props.transaction}
                                             setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.BANK_LOAN ?
                    <BankLoanTransaction transaction={props.transaction}
                                         setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.SERVICE_REVENUES ?
                    <ServiceRevenuesTransaction transaction={props.transaction}
                                                setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.PUBLIC_SERVICES_EXPENSES ?
                    <PublicServicesExpensesTransaction transaction={props.transaction}
                                                       setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.RENT_EXPENSES ?
                    <RentExpensesTransaction transaction={props.transaction}
                                             setTransaction={props.setTransaction}/> : null}
                {transactionTypeSelection?.type === TransactionType.WAGES_EXPENSES ?
                    <WagesExpensesTransaction transaction={props.transaction}
                                              setTransaction={props.setTransaction}/> : null}
            </section>
        </div>
    );
}