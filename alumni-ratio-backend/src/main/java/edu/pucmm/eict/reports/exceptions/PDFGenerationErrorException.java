package edu.pucmm.eict.reports.exceptions;

import java.io.IOException;

public class PDFGenerationErrorException extends RuntimeException {
    private final IOException furtherDetails;

    public PDFGenerationErrorException(String message, IOException furtherDetails) {
        super(message);
        this.furtherDetails = furtherDetails;
    }

    public IOException getFurtherDetails() {
        return furtherDetails;
    }
}
