package job.scheduler;

import job.scheduler.service.DemoService;

public class JobScheduler {

    public static void main(String[] args) {
        DemoService demoService = new DemoService();
        demoService.demo();
    }
}
