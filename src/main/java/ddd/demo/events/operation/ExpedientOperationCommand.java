package ddd.demo.events.operation;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class ExpedientOperationCommand {

    private String expedientId;
    private  String archivalCenterId;

    public ExpedientOperationCommand(String expedientId, String archivalCenterId) {
        this.expedientId = expedientId;
        this.archivalCenterId = archivalCenterId;
        Assert.isTrue(!StringUtils.isEmpty(expedientId), "'expedientId' must not be empty");
        Assert.isTrue(!StringUtils.isEmpty(archivalCenterId), "'archivalCenterId' must not be empty");
    }

    public String getExpedientId(){
        return expedientId;
    }

    public String getArchivalCenterId(){
        return archivalCenterId;
    }
}
