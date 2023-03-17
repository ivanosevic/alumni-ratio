package edu.pucmm.eict.reports;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.AreaBreakType;
import com.itextpdf.layout.properties.UnitValue;
import edu.pucmm.eict.exercises.SolvedExercise;

import java.io.IOException;

public class GeneralInformationSection extends SolvedExercisePdfSection {

    public GeneralInformationSection(PdfDocument PdfDocument, SolvedExercise solvedExercise) {
        super(PdfDocument, solvedExercise);
    }

    @Override
    public void addSection() throws IOException {
        var document = new Document(pdfDocument);
        // document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        // document.add(new AreaBreak(PageSize.A4));
        document.setFontSize(12.0f);
        var text = new Text("General Information Text").setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
//        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
//
//        for (int i = 0; i < 16; i++) {
//            table.addCell("hi");
//        }
//
//        document.add(table);
         document.add(new Paragraph().add(text));
        document.close();
    }
}
