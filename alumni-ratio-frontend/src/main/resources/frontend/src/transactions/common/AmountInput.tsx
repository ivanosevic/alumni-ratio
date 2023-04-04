import {InputNumber, InputNumberValueChangeEvent} from "primereact/inputnumber";
import React from "react";

interface AmountInputProps {
    label?: string;
    amountValue: number | undefined;
    onAmountChangedEvent: (e: InputNumberValueChangeEvent) => void;
}

export default function AmountInput(props: AmountInputProps) {
    return (
        <>
            <div className="field">
                <label className="text-base" htmlFor="number-input">
                    { props.label }
                </label>
                <div className="col">
                    <InputNumber
                        value={props.amountValue}
                        onValueChange={props.onAmountChangedEvent}
                        mode="currency"
                        currency="USD"
                        locale="en-US"
                        minFractionDigits={2}
                        className="w-full md:w-5"
                    />
                </div>
            </div>
        </>
    );
}
