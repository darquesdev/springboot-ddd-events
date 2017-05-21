package ddd.demo.events.operation;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private List<Object> events = new ArrayList<>();

    public void add(Object event){
        this.events.add(event);
    }

    public List events() {
        return events;
    }

    public Object getLastEvent() {
        return events.get(events.size() - 1);
    }

    private static class Loader {
        static EventBus INSTANCE = new EventBus();
    }

    private EventBus() {}

    public static EventBus get() {
        return Loader.INSTANCE;
    }

}
