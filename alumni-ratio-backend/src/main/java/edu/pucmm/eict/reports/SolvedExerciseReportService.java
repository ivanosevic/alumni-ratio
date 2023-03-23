package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
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

        var document = new Document(report);

        var generalInformationSection = new GeneralInformationSection(report, solvedExercise, document);
        var transactionSection = new TransactionSection(report, solvedExercise,document );
        var generalJournalSection = new GeneralJournalSection(report, solvedExercise, document);
        var generalLedgerSection = new GeneralLedgerSection(report, solvedExercise, document);
        var trialBalanceSection = new TrialBalanceSection(report, solvedExercise, document);

        generalInformationSection.generateSection();
        transactionSection.generateSection();
        generalJournalSection.generateSection();
        generalLedgerSection.generateSection();
        trialBalanceSection.generateSection();

        document.close();

        return new SolvedExerciseReport(pdfByteArray.toByteArray(), LocalDateTime.now());
    }
}
