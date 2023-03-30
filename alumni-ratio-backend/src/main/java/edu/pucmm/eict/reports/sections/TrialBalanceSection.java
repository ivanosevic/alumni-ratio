package edu.pucmm.eict.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;



public class TrialBalanceSection extends SolvedExercisePDFSection {

    public TrialBalanceSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document)
    {
        super(pdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() throws IOException
    {
        var helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        var mainHeaderText = new Text("Balanza de Comprobación")
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

        var trialBalanceTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var trialBalanceTitle = new Cell(0, 4)
                .add(new Paragraph("Balanza de Comprobación").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var trialBalanceSheetTitle = new Cell(0, 1)
                .add(new Paragraph("Hoja 1").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var accountNumberHeaderCell = new Cell()
                .add(new Paragraph("No. de Cuenta").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell = new Cell()
                .add(new Paragraph("Concepto").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell = new Cell()
                .add(new Paragraph("Saldos").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell = new Cell()
                .add(new Paragraph("Deudor").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell = new Cell()
                .add(new Paragraph("Acreedor").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        trialBalanceTable.addHeaderCell(trialBalanceTitle);
        trialBalanceTable.addHeaderCell(trialBalanceSheetTitle);
        trialBalanceTable.addHeaderCell(accountNumberHeaderCell);
        trialBalanceTable.addHeaderCell(detailHeaderCell);
        trialBalanceTable.addHeaderCell(countableBalanceHeaderCell);
        trialBalanceTable.addHeaderCell(debitHeaderCell);
        trialBalanceTable.addHeaderCell(creditHeaderCell);

        document.add(trialBalanceTable);
    }

}
