package edu.pucmm.eict.journals.ledger;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GeneralLedgerEntry {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Integer reference;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal value;

    public GeneralLedgerEntry() {
    }

    public GeneralLedgerEntry(LocalDate date, Integer reference, BigDecimal debit, BigDecimal credit, BigDecimal value) {
        this.date = date;
        this.reference = reference;
        this.debit = debit;
        this.credit = credit;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralLedgerEntry that = (GeneralLedgerEntry) o;
        return Objects.equals(date, that.date) && Objects.equals(reference, that.reference) && Objects.equals(debit, that.debit) && Objects.equals(credit, that.credit) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, reference, debit, credit, value);
    }
}
