import {PaymentType, Transaction, TransactionType, TransactionTypeSelection} from "../models/transaction.model";
import React, {useState} from "react";
import {Dropdown, DropdownChangeEvent} from "primereact/dropdown";


interface PaymentTypeProps {
    label?: string;
    transaction: Transaction | undefined;
    setTransaction: React.Dispatch<React.SetStateAction<Transaction | undefined>>;
}

class PaymentTypeSelection {
    type?: PaymentType;
    label?: string;
}

export default function PaymentTypeDropdown(props: PaymentTypeProps) {
    const [paymentType, setPaymentType] = useState<PaymentTypeSelection | null | undefined>();
    const paymentTypes: PaymentTypeSelection[] = [
        {
            label: 'Crédito',
            type: PaymentType.CREDIT
        },
        {
            label: 'Al contado',
            type: PaymentType.DEBIT
        },
        {
            label: 'Mixto',
            type: PaymentType.MIXED
        }
    ];

    const onDropdownChangeEvent = (e: DropdownChangeEvent) => {
        const eventSelection : PaymentTypeSelection = e.value;
        setPaymentType(eventSelection);
        props.setTransaction(prevState => {
            return {
                ...prevState,
                paymentType: eventSelection.type
            }
        });
    };

    return (
        <div className="field">
            <label>{props.label}</label>
            <div className="col">
                <Dropdown value={paymentType} onChange={onDropdownChangeEvent}
                          options={paymentTypes} optionLabel="label" className="w-full md:w-5"
                          placeholder="Tipo de pago"/>
            </div>
        </div>
    );
}