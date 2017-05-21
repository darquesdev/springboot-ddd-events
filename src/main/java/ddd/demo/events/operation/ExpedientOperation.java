package ddd.demo.events.operation;

import java.util.UUID;

public class ExpedientOperation {


    public String init(ExpedientOperationCommand aCommand) {

        String operationId = UUID.randomUUID().toString();

        EventBus.get().add(new ExpedientOperationStartedEvent(
                operationId,
                ExpedientOperations.INICIAR_INGRESO,
                aCommand.getExpedientId(),
                aCommand.getArchivalCenterId()
                ));

        return operationId;
    }

    public void execute(ExpedientOperationCommand aCommand) {
    }
}
