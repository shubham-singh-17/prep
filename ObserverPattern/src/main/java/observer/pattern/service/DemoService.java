package observer.pattern.service;

import observer.pattern.editor.Editor;
import observer.pattern.event.EventType;
import observer.pattern.listener.impl.EmailEventListener;
import observer.pattern.listener.impl.LogEventListener;

public class DemoService {

    public void demo() {
        Editor editor = new Editor();
        LogEventListener logEventListener = new LogEventListener();
        EmailEventListener emailEventListener = new EmailEventListener();

        editor.eventManager.subscribe(EventType.OPEN, logEventListener);
        editor.eventManager.subscribe(EventType.SAVE, logEventListener);
        editor.eventManager.subscribe(EventType.SAVE, emailEventListener);

        editor.openFile("demo.txt");
        editor.saveFile();
    }
}
