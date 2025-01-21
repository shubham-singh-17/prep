package observer.pattern.listener.impl;

import observer.pattern.event.EventType;
import observer.pattern.listener.EventListener;

public class EmailEventListener implements EventListener {

    @Override
    public void update(EventType eventType, String filePath) {
        System.out.printf("Emailing to user for operation %s on file %s%n", eventType, filePath);
    }
}
