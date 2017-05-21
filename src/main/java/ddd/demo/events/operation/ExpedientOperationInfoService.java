package ddd.demo.events.operation;

public interface ExpedientOperationInfoService {

    void add(ExpedientOperationInfo expOpInfo);
    ExpedientOperationInfo findById(String opId);
}
