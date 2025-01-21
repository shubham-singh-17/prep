package cache;

import cache.service.DemoService;

public class CacheMain {

    public static void main(String[] args) {
        DemoService demoService = new DemoService();
        demoService.demo();
    }
}
