package ddd.demo.events.operation;

import java.util.UUID;

public class ExpedientOperationImpl extends InternalExpedientOperation {

    public ExpedientOperationImpl(ExpedientOperationInfoService expedientOperationInfoService) {
        super(expedientOperationInfoService);
    }

    @Override
    public String init(final ExpedientOperationCommand aCommand) {

        String operationId = UUID.randomUUID().toString();

        EventBus.get().add(new ExpedientOperationStartedEvent(
                operationId,
                ExpedientOperations.INICIAR_INGRESO,
                aCommand.getExpedientId(),
                aCommand.getArchivalCenterId()
                ));

        //TODO esto irá en el handle del evento

        OperationExecutionCache.get().putExpedientOperationExecution(
                ExpedientOperations.INICIAR_INGRESO,
                aCommand.getExpedientId(),
                aCommand.getArchivalCenterId()
        );

        this.expedientOperationInfoService.add(new ExpedientOperationInfo(operationId));

        return operationId;
    }

    @Override
    public void doTransactional(final ExpedientOperationCommand aCommand) {

    }

    @Override
    public void doPost(final ExpedientOperationCommand aCommand) {

    }

    @Override
    public void execute(final ExpedientOperationCommand aCommand) {
    }
}
