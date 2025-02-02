package job.scheduler.service;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import job.scheduler.enums.TaskType;
import job.scheduler.job.Job;
import job.scheduler.job.JobExecutor;

public class SchedulerService {

    private static final SchedulerService INSTANCE = new SchedulerService(Runtime.getRuntime().availableProcessors()-1);
    private final PriorityQueue<Job> jobPriorityQueue;
    private final Lock queueLock;
    private final Condition entryAdded;

    private SchedulerService(int threadCount) {
        this.jobPriorityQueue = new PriorityQueue<>();
        this.queueLock = new ReentrantLock();
        this.entryAdded = queueLock.newCondition();

        Thread executor = new Thread(new JobExecutor(jobPriorityQueue, queueLock, entryAdded, threadCount));
        executor.start();
    }

    public static SchedulerService getInstance() {
        return INSTANCE;
    }

    private void addToJobQueue(Job job) {
        queueLock.lock();
        try {
            jobPriorityQueue.offer(job);
            entryAdded.signal();
        } finally {
            queueLock.unlock();
        }
    }

    public void schedule(Runnable task, int initialDelay, TimeUnit timeUnit) {
        Date date = new Date(System.currentTimeMillis() + timeUnit.toMillis(initialDelay));
        Job job = new Job(task, date);

        addToJobQueue(job);
    }


    public void scheduleAtFixedRate(Runnable task, int initialDelay, int recurringDelay, TimeUnit timeUnit) {
        Date date = new Date(System.currentTimeMillis() + timeUnit.toMillis(initialDelay));
        Job job = new Job(task, date, recurringDelay, timeUnit, TaskType.REPEAT_FIXED_RATE);

        addToJobQueue(job);
    }

    public void scheduleAtFixedRateWithTaskTime(Runnable task, int initialDelay, int recurringDelay, TimeUnit timeUnit) {
        Date date = new Date(System.currentTimeMillis() + timeUnit.toMillis(initialDelay));
        Job job = new Job(task, date, recurringDelay, timeUnit, TaskType.REPEAT_FIXED_DELAY);

        addToJobQueue(job);
    }
}
