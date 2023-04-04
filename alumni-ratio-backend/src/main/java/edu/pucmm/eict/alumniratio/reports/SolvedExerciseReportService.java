package edu.pucmm.eict.alumniratio.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import edu.pucmm.eict.alumniratio.exercises.SolvedExercise;
import edu.pucmm.eict.alumniratio.reports.models.SolvedExerciseReport;
import edu.pucmm.eict.alumniratio.reports.sections.GeneralInformationSection;
import edu.pucmm.eict.alumniratio.reports.sections.GeneralJournalSection;
import edu.pucmm.eict.alumniratio.reports.sections.TransactionSection;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

public class SolvedExerciseReportService {

    public SolvedExerciseReport getSolvedExerciseReport(SolvedExercise solvedExercise) {
        var pdfByteArray = new ByteArrayOutputStream();
        var pdfWriter = new PdfWriter(pdfByteArray);
        PdfDocument report = new PdfDocument(pdfWriter);
        var document = new Document(report);

        var generalInformationSection = new GeneralInformationSection(report, document, solvedExercise);
        var transactionSection = new TransactionSection(report, solvedExercise, document);
        var generalJournalSection = new GeneralJournalSection(report, solvedExercise, document);
        var generalLedgerSection = new edu.pucmm.eict.reports.sections.GeneralLedgerSection(report, solvedExercise, document);
        var trialBalanceSection = new edu.pucmm.eict.reports.sections.TrialBalanceSection(report, solvedExercise, document);

        generalInformationSection.generateSection();
        transactionSection.generateSection();
        generalJournalSection.generateSection();
        generalLedgerSection.generateSection();
        trialBalanceSection.generateSection();

        document.close();

        return new SolvedExerciseReport(pdfByteArray.toByteArray(), LocalDateTime.now());
    }
}
