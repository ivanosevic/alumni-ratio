package edu.pucmm.eict.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.exercises.ExerciseController;
import edu.pucmm.eict.exercises.SolvedExercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GeneralJournalSection extends SolvedExercisePDFSection {

    private final static Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    public GeneralJournalSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document) {
        super(pdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() throws IOException {
        logger.info("Generating Section Body for {}", this.getClass().getSimpleName());
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

        logger.info("Added mainHeaderParagraph for {}", this.getClass().getSimpleName());

        var generalJournalTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var companyNameCell = new Cell(0, 5)
                .add(new Paragraph(solvedExercise.getExercise().getCompanyName()).setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var generalJournalTitle = new Cell(0, 4)
                .add(new Paragraph("Diario General").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var generalJournalSheetTitle = new Cell(0, 1)
                .add(new Paragraph("Hoja 1").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var dateHeaderCell = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var referenceHeaderCell = new Cell()
                .add(new Paragraph("Referencia").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        generalJournalTable.addHeaderCell(companyNameCell);
        generalJournalTable.addHeaderCell(generalJournalTitle);
        generalJournalTable.addHeaderCell(generalJournalSheetTitle);
        generalJournalTable.addHeaderCell(dateHeaderCell);
        generalJournalTable.addHeaderCell(detailHeaderCell);
        generalJournalTable.addHeaderCell(referenceHeaderCell);
        generalJournalTable.addHeaderCell(debitHeaderCell);
        generalJournalTable.addHeaderCell(creditHeaderCell);

        for(var generalJournalEntry : solvedExercise.getGeneralJournal().getGeneralJournalEntries()) {
            for(var generalJournalRow : generalJournalEntry.getGeneralJournalRows()) {
                var dateDataCell = new Cell()
                        .add(new Paragraph(generalJournalRow.getDate().toString()).setTextAlignment(TextAlignment.CENTER))
                        .setFont(helveticaFont)
                        .setFontColor(ColorConstants.BLACK)
                        .setFontSize(12f);

                var detailDataCell = new Cell()
                        .add(new Paragraph(generalJournalRow.getDetail()).setTextAlignment(TextAlignment.CENTER))
                        .setFont(helveticaFont)
                        .setFontColor(ColorConstants.BLACK)
                        .setFontSize(12f);

                var referenceDataCell = new Cell()
                        .add(new Paragraph(generalJournalRow.getReference().toString()).setTextAlignment(TextAlignment.CENTER))
                        .setFont(helveticaFont)
                        .setFontColor(ColorConstants.BLACK)
                        .setFontSize(12f);

                var debitDataCell = new Cell()
                        .add(new Paragraph(generalJournalRow.getDebit().toString()).setTextAlignment(TextAlignment.CENTER))
                        .setFont(helveticaFont)
                        .setFontColor(ColorConstants.BLACK)
                        .setFontSize(12f);

                var creditDataCell = new Cell()
                        .add(new Paragraph(generalJournalRow.getCredit().toString()).setTextAlignment(TextAlignment.CENTER))
                        .setFont(helveticaFont)
                        .setFontColor(ColorConstants.BLACK)
                        .setFontSize(12f);

                generalJournalTable.addCell(dateDataCell);
                generalJournalTable.addCell(detailDataCell);
                generalJournalTable.addCell(referenceDataCell);
                generalJournalTable.addCell(debitDataCell);
                generalJournalTable.addCell(creditDataCell);
            }
        }

        document.add(generalJournalTable);

        logger.info("Added general journal table for {}", this.getClass().getSimpleName());
    }
}
