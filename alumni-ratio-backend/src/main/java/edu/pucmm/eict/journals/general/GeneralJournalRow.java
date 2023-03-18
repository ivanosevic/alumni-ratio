package edu.pucmm.eict.journals.general;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GeneralJournalRow {
    private LocalDate date;
    private Integer reference;
    private String detail;
    private BigDecimal debit;
    private BigDecimal credit;

    public GeneralJournalRow() {
    }

    public GeneralJournalRow(LocalDate date, Integer reference, String detail, BigDecimal debit, BigDecimal credit) {
        this.date = date;
        this.reference = reference;
        this.detail = detail;
        this.debit = debit;
        this.credit = credit;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralJournalRow that = (GeneralJournalRow) o;
        return Objects.equals(date, that.date) && Objects.equals(reference, that.reference) && Objects.equals(detail, that.detail) && Objects.equals(debit, that.debit) && Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, reference, detail, debit, credit);
    }

    @Override
    public String toString() {
        return "GeneralJournalRow{" +
                "date=" + date +
                ", detail='" + detail + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                '}';
    }
}
