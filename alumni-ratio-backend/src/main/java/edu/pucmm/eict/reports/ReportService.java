package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReportService {

    public Report getSolvedExerciseReport(SolvedExercise solvedExercise) throws IOException {
        var pdfByteArray = new ByteArrayOutputStream();
        var pdfWriter = new PdfWriter(pdfByteArray);
        PdfDocument report = new PdfDocument(pdfWriter);

        var generalInformationSection = new GeneralInformationSection(report, solvedExercise);
        var transactionSection = new TransactionSection(report, solvedExercise);
        var generalJournalSection = new GeneralJournalSection(report, solvedExercise);
        var generalLedgerSection = new GeneralLedgerSection(report, solvedExercise);
        var trialBalanceSection = new TrialBalanceSection(report, solvedExercise);

        generalInformationSection.addSection();
        transactionSection.addSection();
        generalJournalSection.addSection();
        generalLedgerSection.addSection();
        trialBalanceSection.addSection();

        return new Report(pdfByteArray.toByteArray(), LocalDateTime.now());
    }
}
