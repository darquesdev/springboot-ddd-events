package ddd.demo.events.operation;

import java.time.LocalDateTime;

public class ExpedientOperationExecution {

    private LocalDateTime dateTime;
    private ExpedientOperations operation;
    private String expedientIdentifier;
    private String archivalCenterId;

    public ExpedientOperationExecution(ExpedientOperations operation, String expedientIdentifier, String archivalCenterId) {
        this();
        this.operation = operation;
        this.expedientIdentifier = expedientIdentifier;
        this.archivalCenterId = archivalCenterId;
    }

    public ExpedientOperationExecution() {
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ExpedientOperations getOperation() {
        return operation;
    }

    public void setOperation(ExpedientOperations operation) {
        this.operation = operation;
    }

    public String getExpedientIdentifier() {
        return expedientIdentifier;
    }

    public void setExpedientIdentifier(String expedientIdentifier) {
        this.expedientIdentifier = expedientIdentifier;
    }

    public String getArchivalCenterId() {
        return archivalCenterId;
    }

    public void setArchivalCenterId(String archivalCenterId) {
        this.archivalCenterId = archivalCenterId;
    }
}
