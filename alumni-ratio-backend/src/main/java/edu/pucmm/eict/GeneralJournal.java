package edu.pucmm.eict;

//Este es el diario general en el que se registran las primeras transacciones
public class GeneralJournal
{
    private Transaction GeneralJournalEntry[];

    public GeneralJournal(Transaction[] generalJournalEntry)
    {
        GeneralJournalEntry = generalJournalEntry;
    }

    public Transaction[] getGeneralJourneyEntry()
    {
        return GeneralJournalEntry;
    }
}
