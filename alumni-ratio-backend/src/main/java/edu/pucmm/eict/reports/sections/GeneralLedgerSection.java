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
import edu.pucmm.eict.accounts.AccountBook;
import edu.pucmm.eict.exercises.SolvedExercise;
import edu.pucmm.eict.journals.general.analyzer.RentExpensesEntryAnalyzer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GeneralLedgerSection extends SolvedExercisePDFSection {

    public GeneralLedgerSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document) {
        super(pdfDocument, solvedExercise, document);
    }

    private Table buildGeneralLedgerTable(String name, PdfFont font, Integer accountType) {
        var cashTableAccountTitle = new Cell(0, 5)
                .add(new Paragraph(name).setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var generalLedgerSheetTitle = new Cell(0, 1)
                .add(new Paragraph("Hoja 1").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var dateHeaderCell = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(font)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var generalLedgerTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        generalLedgerTable.addHeaderCell(cashTableAccountTitle);
        generalLedgerTable.addHeaderCell(generalLedgerSheetTitle);
        generalLedgerTable.addHeaderCell(dateHeaderCell);
        generalLedgerTable.addHeaderCell(detailHeaderCell);
        generalLedgerTable.addHeaderCell(debitHeaderCell);
        generalLedgerTable.addHeaderCell(creditHeaderCell);
        generalLedgerTable.addHeaderCell(countableBalanceHeaderCell);
        return generalLedgerTable;
    }

    @Override
    public void sectionBody() throws IOException {
        var helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        var mainHeaderText = new Text("Mayor General")
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


        var cashTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.CASH);
        var officeSuppliesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.OFFICE_SUPPLIES);
        var officeEquipmentTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.OFFICE_EQUIPMENT);
        var landsTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.LANDS);
        var customersTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.CUSTOMERS);
        var notesPayablesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.NOTES_PAYABLES);
        var accountsPayablesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.ACCOUNTS_PAYABLES);
        var companyCapitalTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.COMPANY_CAPITAL);
        var services_RevenuesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.SERVICES_REVENUES);
        var wagesExpensesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.WAGES_EXPENSES);
        var rentExpensesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.RENT_EXPENSES);
        var publicServicesExpensesTable = buildGeneralLedgerTable("Efectivo", helveticaFont, AccountBook.PUBLIC_SERVICES_EXPENSES);

        document.add(cashTable);
        document.add(officeSuppliesTable);
        document.add(officeEquipmentTable);
        document.add(landsTable);
        document.add(customersTable);
        document.add(notesPayablesTable);
        document.add(accountsPayablesTable);
        document.add(companyCapitalTable);
        document.add(services_RevenuesTable);
        document.add(wagesExpensesTable);
        document.add(rentExpensesTable);
        document.add(publicServicesExpensesTable);
    }
}
