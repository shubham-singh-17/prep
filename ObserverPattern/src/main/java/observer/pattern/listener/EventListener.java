package observer.pattern.listener;

import observer.pattern.event.EventType;

public interface EventListener {

    void update(EventType eventType, String filePath);
}
