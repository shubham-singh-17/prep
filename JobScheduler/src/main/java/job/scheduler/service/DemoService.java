package job.scheduler.service;

import java.util.concurrent.TimeUnit;

public class DemoService {

    private final SchedulerService schedulerService;

    public DemoService() {
        schedulerService = SchedulerService.getInstance();
    }

    public void demo() {
        Runnable task1 = () -> System.out.println("Task1 executed");
        Runnable task2 = () -> System.out.println("Task2 executed");
        Runnable task3 = () -> {
            System.out.println("Task3 executed");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        schedulerService.schedule(task1, 10, TimeUnit.SECONDS);
        schedulerService.scheduleAtFixedRate(task2, 5, 5, TimeUnit.SECONDS);
        schedulerService.scheduleAtFixedRateWithTaskTime(task3, 5, 5, TimeUnit.SECONDS);
    }
}
