package edu.pucmm.eict.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
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

        var cashTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var cashTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Efectivo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var generalLedgerSheetTitle = new Cell(0, 1)
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

        var countableBalanceHeaderCell = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        cashTable.addHeaderCell(cashTableAccountTitle);
        cashTable.addHeaderCell(generalLedgerSheetTitle);
        cashTable.addHeaderCell(dateHeaderCell);
        cashTable.addHeaderCell(detailHeaderCell);
        cashTable.addHeaderCell(debitHeaderCell);
        cashTable.addHeaderCell(creditHeaderCell);
        cashTable.addHeaderCell(countableBalanceHeaderCell);

        var officeSuppliesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var officeSuppliesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Materiales de Oficina").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCellOS = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCellOS = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCellOS = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCellOS = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCellOS = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        officeSuppliesTable.addHeaderCell(officeSuppliesTableAccountTitle);
        officeSuppliesTable.addHeaderCell(dateHeaderCellOS);
        officeSuppliesTable.addHeaderCell(detailHeaderCellOS);
        officeSuppliesTable.addHeaderCell(debitHeaderCellOS);
        officeSuppliesTable.addHeaderCell(creditHeaderCellOS);
        officeSuppliesTable.addHeaderCell(countableBalanceHeaderCellOS);

        var officeEquipmentTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var officeEquipmentTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Equipos de Oficina").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCellOE = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCellOE = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCellOE = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCellOE = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCellOE = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        officeEquipmentTable.addHeaderCell(officeEquipmentTableAccountTitle);
        officeEquipmentTable.addHeaderCell(dateHeaderCellOE);
        officeEquipmentTable.addHeaderCell(detailHeaderCellOE);
        officeEquipmentTable.addHeaderCell(debitHeaderCellOE);
        officeEquipmentTable.addHeaderCell(creditHeaderCellOE);
        officeEquipmentTable.addHeaderCell(countableBalanceHeaderCellOE);


        var landsTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var landsTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Terrenos").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_lands = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_lands = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_lands = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_lands = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_lands = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        landsTable.addHeaderCell(landsTableAccountTitle);
        landsTable.addHeaderCell(dateHeaderCell_lands);
        landsTable.addHeaderCell(detailHeaderCell_lands);
        landsTable.addHeaderCell(debitHeaderCell_lands);
        landsTable.addHeaderCell(creditHeaderCell_lands);
        landsTable.addHeaderCell(countableBalanceHeaderCell_lands);

        var customersTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var customersTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Clientes").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_cust = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_cust = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_cust = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_cust = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_cust = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        customersTable.addHeaderCell(customersTableAccountTitle);
        customersTable.addHeaderCell(dateHeaderCell_cust);
        customersTable.addHeaderCell(detailHeaderCell_cust);
        customersTable.addHeaderCell(debitHeaderCell_cust);
        customersTable.addHeaderCell(creditHeaderCell_cust);
        customersTable.addHeaderCell(countableBalanceHeaderCell_cust);

        var notesPayablesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var notesPayablesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Cuentas por cobrar").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_NP = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_NP = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_NP = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_NP = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_NP = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        notesPayablesTable.addHeaderCell(notesPayablesTableAccountTitle);
        notesPayablesTable.addHeaderCell(dateHeaderCell_NP);
        notesPayablesTable.addHeaderCell(detailHeaderCell_NP);
        notesPayablesTable.addHeaderCell(debitHeaderCell_NP);
        notesPayablesTable.addHeaderCell(creditHeaderCell_NP);
        notesPayablesTable.addHeaderCell(countableBalanceHeaderCell_NP);

        var accountsPayablesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var accountsPayablesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Cuentas por pagar").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_AP = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_AP = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_AP = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_AP = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_AP = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        accountsPayablesTable.addHeaderCell(accountsPayablesTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_AP);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_AP);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_AP);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_AP);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_AP);

        var companyCapitalTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var companyCapitalTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Capital Contable").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_CC = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_CC = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_CC = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_CC = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_CC = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        companyCapitalTable.addHeaderCell(companyCapitalTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_CC);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_CC);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_CC);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_CC);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_CC);

        var services_RevenuesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var services_RevenuesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Ingresos").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_SR = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_SR = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_SR = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_SR = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_SR = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        services_RevenuesTable.addHeaderCell(services_RevenuesTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_SR);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_SR);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_SR);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_SR);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_SR);

        var wagesExpensesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var wagesExpensesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Salario").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_WE = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_WE = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_WE = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_WE = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_WE = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        wagesExpensesTable.addHeaderCell(wagesExpensesTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_WE);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_WE);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_WE);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_WE);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_WE);

        var rentExpensesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var rentExpensesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Renta").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_RE = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_RE = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_RE = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_RE = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_RE = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        rentExpensesTable.addHeaderCell(rentExpensesTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_RE);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_RE);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_RE);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_RE);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_RE);

        var publicServicesExpensesTable = new Table(UnitValue.createPercentArray(5)).useAllAvailableWidth();

        var publicServicesExpensesTableAccountTitle = new Cell(0, 1)
                .add(new Paragraph("Gastos de Servicios Públicos").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);


        var dateHeaderCell_PSE = new Cell()
                .add(new Paragraph("Fecha").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var detailHeaderCell_PSE = new Cell()
                .add(new Paragraph("Detalle").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var debitHeaderCell_PSE = new Cell()
                .add(new Paragraph("Debe").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var creditHeaderCell_PSE = new Cell()
                .add(new Paragraph("Haber").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        var countableBalanceHeaderCell_PSE = new Cell()
                .add(new Paragraph("Saldo").setTextAlignment(TextAlignment.CENTER))
                .setFont(helveticaFont)
                .setFontColor(ColorConstants.BLACK)
                .setFontSize(12f);

        publicServicesExpensesTable.addHeaderCell(publicServicesExpensesTableAccountTitle);
        accountsPayablesTable.addHeaderCell(dateHeaderCell_PSE);
        accountsPayablesTable.addHeaderCell(detailHeaderCell_PSE);
        accountsPayablesTable.addHeaderCell(debitHeaderCell_PSE);
        accountsPayablesTable.addHeaderCell(creditHeaderCell_PSE);
        accountsPayablesTable.addHeaderCell(countableBalanceHeaderCell_PSE);

        var moneyFormatter = new DecimalFormat("#,##0.00");
        moneyFormatter.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));

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
