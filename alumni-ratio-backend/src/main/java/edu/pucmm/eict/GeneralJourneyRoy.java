package edu.pucmm.eict;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GeneralJourneyRoy
{
    private Integer id;
    private LocalDate date;
    private String detail;
    private BigDecimal debit;
    private BigDecimal credit;

    public GeneralJourneyRoy(Integer id, LocalDate date, String detail, BigDecimal debit, BigDecimal credit)
    {
        this.id = id;
        this.date = date;
        this.detail = detail;
        this.debit = debit;
        this.credit = credit;
    }

    public Integer getId()
    {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public String getDetail()
    {
        return detail;
    }

    public BigDecimal getDebit()
    {
        return debit;
    }

    public BigDecimal getCredit()
    {
        return credit;
    }
}
