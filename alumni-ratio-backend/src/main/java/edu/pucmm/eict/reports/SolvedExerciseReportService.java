package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import edu.pucmm.eict.exercises.SolvedExercise;
import edu.pucmm.eict.reports.models.SolvedExerciseReport;
import edu.pucmm.eict.reports.sections.*;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

public class SolvedExerciseReportService {

    public SolvedExerciseReport getSolvedExerciseReport(SolvedExercise solvedExercise) {
        var pdfByteArray = new ByteArrayOutputStream();
        var pdfWriter = new PdfWriter(pdfByteArray);
        PdfDocument report = new PdfDocument(pdfWriter);

        var generalInformationSection = new GeneralInformationSection(report, solvedExercise);
        var transactionSection = new TransactionSection(report, solvedExercise);
        var generalJournalSection = new GeneralJournalSection(report, solvedExercise);
        var generalLedgerSection = new GeneralLedgerSection(report, solvedExercise);
        var trialBalanceSection = new TrialBalanceSection(report, solvedExercise);

        generalInformationSection.generateSection();
        transactionSection.generateSection();
        generalJournalSection.generateSection();
        generalLedgerSection.generateSection();
        trialBalanceSection.generateSection();

        return new SolvedExerciseReport(pdfByteArray.toByteArray(), LocalDateTime.now());
    }
}
