package edu.pucmm.eict.reports.sections;

import com.itextpdf.kernel.pdf.PdfDocument;
import edu.pucmm.eict.exercises.SolvedExercise;

public class TransactionSection extends SolvedExercisePDFSection {

    public TransactionSection(PdfDocument pdfDocument, SolvedExercise solvedExercise) {
        super(pdfDocument, solvedExercise);
    }

    @Override
    public void sectionBody() {
    }
}