package ddd.demo.events.operation;

public class ExpedientOperationInfo {


    public ExpedientOperationInfo(String id) {
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
