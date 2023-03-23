package edu.pucmm.eict.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;

public class GeneralJournalSection extends SolvedExercisePDFSection {

    public GeneralJournalSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document)
    {
        super(pdfDocument, solvedExercise,document);
    }

    @Override
    public void sectionBody() throws IOException {
        var helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        var mainHeaderText = new Text("Diario General")
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(14.0f)
                .setFont(helveticaFont);

        var line = new SolidLine();
        line.setColor(ColorConstants.BLACK);
        line.setLineWidth(1.0f);
        var lineSeparator = new LineSeparator(line);
        lineSeparator.setWidth(UnitValue.createPercentValue(100));
        lineSeparator.setMarginTop(5.0f);
        var mainHeaderParagraph = new Paragraph(mainHeaderText).add(lineSeparator);
        document.add(mainHeaderParagraph);

        float[] columnWidths = {100f, 100f, 100f, 100f, 100f};
        var generalJournalTable = new Table(columnWidths);

        var companyNameCell = new Cell(columnWidths.length, 0)
                .add(new Paragraph(solvedExercise.getExercise().getCompanyName()))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var dateHeaderCell = new Cell()
                .add(new Paragraph("Fecha"))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell = new Cell()
                .add(new Paragraph("Detalle"))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var referenceHeaderCell = new Cell()
                .add(new Paragraph("Referencia"))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell = new Cell()
                .add(new Paragraph("Debe"))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell = new Cell()
                .add(new Paragraph("Haber"))
                .setFont(helveticaFont).setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        generalJournalTable.addHeaderCell(companyNameCell);
        generalJournalTable.addHeaderCell(dateHeaderCell);
        generalJournalTable.addHeaderCell(detailHeaderCell);
        generalJournalTable.addHeaderCell(referenceHeaderCell);
        generalJournalTable.addHeaderCell(debitHeaderCell);
        generalJournalTable.addHeaderCell(creditHeaderCell);

        document.add(generalJournalTable);


    }
}
