package ddd.demo.events.operation;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class ExpedientIdentifierCreator {

    public static String createExpedientUuid(String archiveId, String expedientId){
        Assert.isTrue(!StringUtils.isEmpty(archiveId), "'archiveId' must not be empty");
        Assert.isTrue(!StringUtils.isEmpty(expedientId), "'expedientId' must not be empty");
        return archiveId + "." + expedientId;
    }

}
