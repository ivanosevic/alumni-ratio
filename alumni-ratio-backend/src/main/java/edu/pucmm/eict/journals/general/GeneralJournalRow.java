package edu.pucmm.eict.journals.general;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GeneralJournalRow {
    private Integer id;
    private LocalDate date;
    private String detail;
    private BigDecimal debit;
    private BigDecimal credit;

    public GeneralJournalRow() {
    }

    public GeneralJournalRow(Integer id, LocalDate date, String detail, BigDecimal debit, BigDecimal credit) {
        this.id = id;
        this.date = date;
        this.detail = detail;
        this.debit = debit;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDetail() {
        return detail;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCredit() {
        return credit;
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
