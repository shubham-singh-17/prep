package observer.pattern.listener.impl;

import observer.pattern.event.EventType;
import observer.pattern.listener.EventListener;

public class LogEventListener implements EventListener {

    @Override
    public void update(EventType eventType, String filePath) {
        System.out.printf("User is trying to do operation %s to file %s%n", eventType, filePath);
    }
}
