package edu.pucmm.eict.reports;

import com.itextpdf.kernel.pdf.PdfDocument;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;

public abstract class SolvedExercisePdfSection {

    protected final PdfDocument pdfDocument;
    protected final SolvedExercise solvedExercise;

    public SolvedExercisePdfSection(PdfDocument pdfDocument, SolvedExercise solvedExercise) {
        this.pdfDocument = pdfDocument;
        this.solvedExercise = solvedExercise;
    }

    abstract void addSection() throws IOException;
}
