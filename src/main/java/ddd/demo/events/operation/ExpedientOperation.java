package ddd.demo.events.operation;

/**
 * Created by darques on 21/05/17.
 */
public interface ExpedientOperation {
    void execute(ExpedientOperationCommand aCommand);
}
