package edu.pucmm.eict.reports.sections;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;

public class TransactionSection extends SolvedExercisePDFSection {

    public TransactionSection(PdfDocument pdfDocument, SolvedExercise solvedExercise, Document document) {
        super(pdfDocument, solvedExercise, document);
    }

    @Override
    public void sectionBody() throws IOException {
        var helveticaFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        var mainHeaderText = new Text("Transaaciones")
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

    }
}
