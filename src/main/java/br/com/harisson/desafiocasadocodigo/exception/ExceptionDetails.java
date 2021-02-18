package br.com.harisson.desafiocasadocodigo.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    private final String title;
    private final LocalDateTime timestamp;
    private final int status;
    private final String fields;
    private final String fieldMessage;


    public ExceptionDetails(String title, LocalDateTime timestamp, int status, String fields, String fieldMessage) {
        this.title = title;
        this.timestamp = timestamp;
        this.status = status;
        this.fields = fields;
        this.fieldMessage = fieldMessage;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getFields() {
        return fields;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }
}
