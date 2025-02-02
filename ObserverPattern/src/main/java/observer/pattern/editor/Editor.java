package observer.pattern.editor;

import observer.pattern.event.EventManager;
import observer.pattern.event.EventType;

public class Editor {

    private String fileName;
    public final EventManager eventManager;

    public Editor() {
        this.eventManager = new EventManager(EventType.OPEN, EventType.SAVE);
    }

    public void openFile(String fileName) {
        this.fileName = fileName;
        eventManager.notify(EventType.OPEN, fileName);
    }

    public void saveFile() {
        eventManager.notify(EventType.SAVE, fileName);
    }
}
