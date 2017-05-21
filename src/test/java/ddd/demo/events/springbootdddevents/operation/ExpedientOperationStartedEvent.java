package ddd.demo.events.springbootdddevents.operation;


import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class ExpedientOperationStartedEvent {

    private String id;
    private ExpedientOperations operation;
    private String expedientUuid;

    public ExpedientOperationStartedEvent(String id, ExpedientOperations operation, String expedientId,String archivalCenterId){
        this(id, operation, createExpedientUuid(archivalCenterId, expedientId));
    }

    public ExpedientOperationStartedEvent(String id, ExpedientOperations operation, String expedientUuid) {
        this.id = id;
        this.operation = operation;
        this.expedientUuid = expedientUuid;
        Assert.isTrue(!StringUtils.isEmpty(id), "'Id' must not be empty");
        Assert.notNull(operation, "'operation' must not be empty");
        Assert.isTrue(!StringUtils.isEmpty(expedientUuid), "'expedientUuid' must not be empty");
    }

    public String getId(){
        return id;
    }

    public ExpedientOperations getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpedientOperationStartedEvent that = (ExpedientOperationStartedEvent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return operation == that.operation;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }

    public String getExpedientUuid() {
        return expedientUuid;
    }

    public static String createExpedientUuid(String archiveId, String expedientId){
        Assert.isTrue(!StringUtils.isEmpty(archiveId), "'expedientId' must not be empty");
        Assert.isTrue(!StringUtils.isEmpty(expedientId), "'expedientId' must not be empty");
        return archiveId + "." + expedientId;
    }
}
