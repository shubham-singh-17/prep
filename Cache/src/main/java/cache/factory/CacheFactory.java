package cache.factory;

import cache.eviction.LRUEvictionPolicy;
import cache.service.Cache;
import cache.storage.HashMapStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> getDefaultCache(int capacity) {
        return new Cache<Key, Value>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
