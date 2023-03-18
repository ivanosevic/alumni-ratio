package edu.pucmm.eict.reports.sections;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import edu.pucmm.eict.exercises.SolvedExercise;
import edu.pucmm.eict.reports.exceptions.PDFGenerationErrorException;

import java.io.IOException;

public abstract class SolvedExercisePDFSection {

    protected final PdfDocument pdfDocument;
    protected final SolvedExercise solvedExercise;
    protected final Document document;

    public SolvedExercisePDFSection(PdfDocument pdfDocument, SolvedExercise solvedExercise) {
        this.pdfDocument = pdfDocument;
        this.solvedExercise = solvedExercise;
        this.document = new Document(pdfDocument);
    }

    protected abstract void sectionBody() throws IOException;

    private void setPdfDefaultProperties() {
        this.pdfDocument.setDefaultPageSize(PageSize.A4);
    }

    public void generateSection() {
        try {
            this.setPdfDefaultProperties();
            this.sectionBody();
            this.document.close();
        } catch (IOException e) {
            throw new PDFGenerationErrorException("There was an error while generating the PDF Report.", e);
        }
    }
}
