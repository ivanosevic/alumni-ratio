package edu.pucmm.eict.alumniratio.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.alumniratio.exercises.SolvedExercise;

import javax.swing.text.StyledEditorKit;
import java.io.IOException;

public class GeneralInformationSection extends SolvedExercisePDFSection {

    public GeneralInformationSection(PdfDocument PdfDocument, Document document, SolvedExercise solvedExercise) {
        super(PdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() throws IOException {
        var helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        var mainHeaderText = new Text("Informaciones generales sobre la empresa")
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

        var companyInformationList = new List()
                .setSymbolIndent(12)
                .setListSymbol("•")
                .setFont(helveticaFont)
                .setFontSize(12.0f)
                .setFontColor(ColorConstants.BLACK);

        var companyNameText = String.format("Nombre de la empresa: %s", solvedExercise.getExercise().getCompanyName());
        var companyOwnerText = String.format("Dueño de la empresa: %s", solvedExercise.getExercise().getCompanyOwner());
        var monthOperationsText = String.format("Mes de operaciones: %d", solvedExercise.getExercise().getMonthOperations());
        var yearOfOperationsText = String.format("Año de operaciones: %d", solvedExercise.getExercise().getYearOperations());

        companyInformationList.add(new ListItem(companyNameText));
        companyInformationList.add(new ListItem(companyOwnerText));
        companyInformationList.add(new ListItem(monthOperationsText));
        companyInformationList.add(new ListItem(yearOfOperationsText));
        document.add(companyInformationList);
    }
}
