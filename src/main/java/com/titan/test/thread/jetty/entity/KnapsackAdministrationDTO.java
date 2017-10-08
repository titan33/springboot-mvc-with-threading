package com.titan.test.thread.jetty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KnapsackAdministrationDTO {

    private String id;
    private String message;
    private String timestamp;
    private String operationType;

    public KnapsackAdministrationDTO(String id, String timestamp, String message, String operationType) {

        this.id = id;
        this.timestamp = timestamp;
        this.message = message;
        this.operationType = operationType;
    }

    public KnapsackAdministrationDTO(String timestamp, String message, String operationType) {

        this.timestamp = timestamp;
        this.message = message;
        this.operationType = operationType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

