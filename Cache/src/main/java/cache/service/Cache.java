package cache.service;

import cache.eviction.EvictionPolicy;
import cache.exception.StorageFullException;
import cache.storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) {
        try {
            storage.add(key, value);
            evictionPolicy.keyAccess(key);
        } catch (StorageFullException ex) {
            System.out.println(ex.getMessage());

            Key evictedKey = evictionPolicy.evictKey();
            storage.remove(evictedKey);

            System.out.println("Removing key : " + evictedKey);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            evictionPolicy.keyAccess(key);

            return storage.get(key);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
