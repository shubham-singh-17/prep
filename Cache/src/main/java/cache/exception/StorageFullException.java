package cache.exception;

public class StorageFullException extends RuntimeException {

    public StorageFullException(String mssg) {
        super(mssg);
    }
}
