package ddd.demo.events.operation;

public abstract class InternalExpedientOperation implements ExpedientOperation {

    protected ExpedientOperationInfoService expedientOperationInfoService;

    public InternalExpedientOperation(ExpedientOperationInfoService expedientOperationInfoService) {
        this.expedientOperationInfoService = expedientOperationInfoService;
    }

    public abstract String init(ExpedientOperationCommand aCommand);
    public abstract void doTransactional(ExpedientOperationCommand aCommand);
    public abstract void doPost(ExpedientOperationCommand aCommand);
}
