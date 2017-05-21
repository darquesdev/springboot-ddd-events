package ddd.demo.events.operation;

import java.util.LinkedHashMap;
import java.util.Map;

public class OperationExecutionCache {

    private Map<String, ExpedientOperationExecution> expOps = new LinkedHashMap<>();

    public void clearExpedientOperationExecutions() {
        expOps.clear();
    }

    private static class Loader {
        static OperationExecutionCache INSTANCE = new OperationExecutionCache();
    }

    static OperationExecutionCache INSTANCE = new OperationExecutionCache ();

    private OperationExecutionCache () {}

    public static OperationExecutionCache  get() {
        return Loader.INSTANCE;
    }

    public ExpedientOperationExecution getExpedientOperationExecution(String expedientId, String archivalCenterId) {
        return expOps.get(createKeyFromExpedient(expedientId, archivalCenterId));
    }

    public void putExpedientOperationExecution(ExpedientOperations operation, String expedientId, String ArchivalCenterId){
        expOps.put(createKeyFromExpedient(expedientId, ArchivalCenterId),
                new ExpedientOperationExecution(operation, expedientId, ArchivalCenterId));
    }

    private String createKeyFromExpedient(String expedientId, String archivalCenterId){
        return "EXP_OP-" + ExpedientIdentifierCreator.createExpedientUuid(archivalCenterId, expedientId);
    }

}
