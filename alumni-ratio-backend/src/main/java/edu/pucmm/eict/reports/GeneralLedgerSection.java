package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import edu.pucmm.eict.exercises.SolvedExercise;

public class GeneralLedgerSection extends SolvedExercisePdfSection {

    public GeneralLedgerSection(PdfDocument pdfDocument, SolvedExercise solvedExercise) {
        super(pdfDocument, solvedExercise);
    }

    @Override
    public void addSection() {
        return;
    }
}
