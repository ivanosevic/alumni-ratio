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
import edu.pucmm.eict.balance.TrialBalanceEntry;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;

import static com.itextpdf.io.font.constants.StandardFonts.HELVETICA;


public class TrialBalanceSection extends SolvedExercisePDFSection {

    public TrialBalanceSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document)
    {
        super(pdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() throws IOException
    {
        var helveticaFont = PdfFontFactory.createFont(HELVETICA);
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

        var trialBalanceTitle = new Cell(0, 5)
                .add(new Paragraph("Balanza de Comprobación").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell = new Cell(2,2)
                .add(new Paragraph("Concepto").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell = new Cell(0,2)
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
        trialBalanceTable.addHeaderCell(detailHeaderCell);
        trialBalanceTable.addHeaderCell(countableBalanceHeaderCell);
        trialBalanceTable.addHeaderCell(debitHeaderCell);
        trialBalanceTable.addHeaderCell(creditHeaderCell);

        for(var trialBalanceEntry: solvedExercise.getTrialBalance().getEntries(trialBalanceTable))
        {
            var balanceCell = new Cell()
                    .add(new Paragraph(String.valueOf(trialBalanceEntry.getClass())).setTextAlignment(TextAlignment.CENTER))
                    .setFont(helveticaFont)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(10f);

            var detailCell = new Cell()
                    .add(new Paragraph(String.valueOf(trialBalanceEntry.getAccountName())).setTextAlignment(TextAlignment.CENTER))
                    .setFont(helveticaFont)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(10f);

            var debitCell = new Cell()
                    .add(new Paragraph(String.valueOf(trialBalanceEntry.getDebit())).setTextAlignment(TextAlignment.CENTER))
                    .setFont(helveticaFont)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(10f);

            var creditCell = new Cell()
                    .add(new Paragraph(String.valueOf(trialBalanceEntry.getCredit())).setTextAlignment(TextAlignment.CENTER))
                    .setFont(helveticaFont)
                    .setFontColor(ColorConstants.BLACK)
                    .setFontSize(10f);

            trialBalanceTable.addCell(balanceCell);
            trialBalanceTable.addCell(detailCell);
            trialBalanceTable.addCell(debitCell);
            trialBalanceTable.addCell(creditCell);

            }

        document.add(trialBalanceTable);
    }
}
