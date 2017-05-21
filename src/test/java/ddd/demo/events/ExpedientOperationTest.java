package ddd.demo.events;

import ddd.demo.events.operation.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;


public class ExpedientOperationTest {

    private String expedientId;
    private String archivalCenterId;
    private ExpedientOperationImpl anExpedientOperation;
    private ExpedientOperationCommand anExpedientOperationCommand;
    private ExpedientOperationInfoService  expedientOperationInfoService = new ExpedientOperationInfoServiceImpl();

    @Before
    public void setup(){
        OperationExecutionCache.get().clearExpedientOperationExecutions();
        EventBus.get().clearEvents();
        expedientId = "expedient-id-test";
        archivalCenterId = "archivalCenter-id-test";
        anExpedientOperation = new ExpedientOperationImpl(expedientOperationInfoService);
        anExpedientOperationCommand = new ExpedientOperationCommand(expedientId, archivalCenterId);
    }

    @Test
    public void execute_an_operation(){

        anExpedientOperation.execute(anExpedientOperationCommand);
    }

    @Test
    public void An_OPERATION_STARTED_EVENT_is_fired_after_initiating_operation(){

        // when
        String operationId = anExpedientOperation.init(anExpedientOperationCommand);


        // then

        assertThat(EventBus.get().events().size(), is(1));
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

    @Test
    public void when_starting_an_expedient_operation_it_is_marked_as_EXECUTING_within_the_cache(){

        // when
        String operationId = anExpedientOperation.init(anExpedientOperationCommand);

        // then
        OperationExecutionCache operationExecutionCache = OperationExecutionCache.get();
        ExpedientOperationExecution execution = operationExecutionCache.getExpedientOperationExecution(expedientId, archivalCenterId);
        assertTrue(execution != null);

    }

    @Test
    public void when_starting_an_expedient_operations_a_logging_register_must_be_persisted(){

        // when
        String opId = anExpedientOperation.init(anExpedientOperationCommand);

        ExpedientOperationInfo expedientOperationInfo = expedientOperationInfoService.findById(opId);

        assertThat(expedientOperationInfo, is(not(nullValue())));
    }

}
