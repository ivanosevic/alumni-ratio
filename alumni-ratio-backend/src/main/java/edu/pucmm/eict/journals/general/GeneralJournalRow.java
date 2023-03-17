package edu.pucmm.eict.journals.general;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GeneralJournalRow {
    private Integer id;
    private LocalDate date;
    private Integer reference;
    private String detail;
    private BigDecimal debit;
    private BigDecimal credit;

    public GeneralJournalRow() {
    }

    public GeneralJournalRow(Integer id, LocalDate date, Integer reference, String detail, BigDecimal debit, BigDecimal credit) {
        this.id = id;
        this.date = date;
        this.reference = reference;
        this.detail = detail;
        this.debit = debit;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GeneralJournalRow{" +
                "id=" + id +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                '}';
    }
}
