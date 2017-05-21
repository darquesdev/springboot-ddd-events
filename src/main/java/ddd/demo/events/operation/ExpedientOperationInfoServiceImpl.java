package ddd.demo.events.operation;

import java.util.LinkedHashMap;

public class ExpedientOperationInfoServiceImpl implements ExpedientOperationInfoService {

    private LinkedHashMap<String, ExpedientOperationInfo> data = new LinkedHashMap<>();

    public ExpedientOperationInfo findById(String opId) {
        return data.get(opId);
    }

    public void add(ExpedientOperationInfo expOpInfo){
        data.put(expOpInfo.getId(), expOpInfo);
    }
}
