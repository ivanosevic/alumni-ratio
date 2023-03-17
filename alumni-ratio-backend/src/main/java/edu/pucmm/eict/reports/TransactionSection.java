package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import edu.pucmm.eict.exercises.SolvedExercise;

public class TransactionSection extends SolvedExercisePdfSection {

    protected TransactionSection(PdfDocument pdfDocument, SolvedExercise solvedExercise) {
        super(pdfDocument, solvedExercise);
    }

    @Override
    public void addSection() {
    }
}
