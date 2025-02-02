package observer.pattern.event;

import observer.pattern.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private Map<EventType, List<EventListener>> listeners = new HashMap<>();

    public EventManager(EventType... events) {
        for (EventType eventType: events) {
            listeners.put(eventType, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void notify(EventType eventType, String fileName) {
        listeners.get(eventType).forEach(listener -> listener.update(eventType, fileName));
    }
}
