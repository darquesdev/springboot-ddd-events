package ddd.demo.events;

import ddd.demo.events.operation.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ExpedientOperationTest {

    @Test
    public void execute_an_operation(){

        String expedientId = "expedient-id-test";
        String archivalCenterId = "archivalCenter-id-test";

        new ExpedientOperation().execute(new ExpedientOperationCommand(expedientId, archivalCenterId));
    }

    @Test
    public void An_OPERATION_STARTED_EVENT_is_fired_after_initiating_operation(){

        // given
        String expedientId = "expedient-id-test";
        String archivalCenterId = "archivalCenter-id-test";

        ExpedientOperation anExpedientOperation = new ExpedientOperation();


        // when
        String operationId = anExpedientOperation.init(new ExpedientOperationCommand(expedientId, archivalCenterId));


        // then
        assertThat(EventBus.get().events().size(), is(1));
        //and
        ExpedientOperationStartedEvent expectedEvent = new ExpedientOperationStartedEvent(
                operationId,
                ExpedientOperations.INICIAR_INGRESO,
                expedientId,
                archivalCenterId);
        ExpedientOperationStartedEvent actualEvent = (ExpedientOperationStartedEvent) EventBus.get().getLastEvent();

        assertThat(expectedEvent, is(equalTo(actualEvent)));
        assertThat(expectedEvent.getOperation(), is(equalTo(actualEvent.getOperation())));
        assertThat(expectedEvent.getExpedientUuid(), is(equalTo(actualEvent.getExpedientUuid())));
    }
}
