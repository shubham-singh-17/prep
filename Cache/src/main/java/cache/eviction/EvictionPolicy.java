package cache.eviction;

public interface EvictionPolicy<Key> {

    void keyAccess(Key key);

    Key evictKey();
}
