package cache.service;

import cache.factory.CacheFactory;

public class DemoService {

    private final CacheFactory<Integer, Integer> cacheFactory;

    public DemoService() {
        this.cacheFactory = new CacheFactory<Integer, Integer>();
    }

    public void demo() {
        Cache<Integer, Integer> cache = cacheFactory.getDefaultCache(3);

        cache.put(2, 3);
        cache.put(4, 2);
        cache.put(9, 10);
        System.out.println(cache.get(9));
        cache.put(6, 7);
        System.out.println(cache.get(6));
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));
    }
}
