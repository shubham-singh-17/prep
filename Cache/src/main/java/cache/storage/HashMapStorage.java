package cache.storage;

import cache.exception.NotFoundException;
import cache.exception.StorageFullException;
import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

    private Map<Key, Value> store;
    private final Integer MAX_CAPACITY;

    public HashMapStorage(Integer capacity) {
        this.store = new HashMap<>();
        this.MAX_CAPACITY = capacity;
    }

    @Override
    public void add(Key key, Value value) {
        if (isStoreFull()) throw new StorageFullException("Storage is full, can not add key : " + key);

        store.put(key, value);
    }

    @Override
    public Value get(Key key) {
        if (!store.containsKey(key)) throw new NotFoundException("Storage doesn't contains key : " + key);

        return store.get(key);
    }

    @Override
    public void remove(Key key) {
        if (!store.containsKey(key)) throw new NotFoundException("Storage doesn't contains key : " + key);

        store.remove(key);
    }

    private boolean isStoreFull() {
        return store.size() == MAX_CAPACITY;
    }
}
