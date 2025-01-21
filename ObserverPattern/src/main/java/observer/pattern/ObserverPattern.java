package observer.pattern;


import observer.pattern.service.DemoService;

public class ObserverPattern {

    public static void main(String[] args) {
        DemoService demoService = new DemoService();
        demoService.demo();
    }
}
