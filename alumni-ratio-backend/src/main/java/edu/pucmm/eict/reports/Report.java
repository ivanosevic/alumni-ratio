package edu.pucmm.eict.reports;

import java.time.LocalDateTime;

public class Report {

    private byte[] content;
    private LocalDateTime createdAt;

    public Report() {
    }

    public Report(byte[] content, LocalDateTime createdAt) {
        this.content = content;
        this.createdAt = createdAt;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
