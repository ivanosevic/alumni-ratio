package edu.pucmm.eict.alumniratio.reports.sections;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import edu.pucmm.eict.alumniratio.exercises.SolvedExercise;

public class GeneralLedgerSection extends SolvedExercisePDFSection {

    public GeneralLedgerSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document) {
        super(pdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() {
        return;
    }
}