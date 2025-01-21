package job.scheduler.job;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class JobExecutor implements Runnable {

    private final ExecutorService executorService;
    private final PriorityQueue<Job> jobPriorityQueue;
    private final Lock queueLock;
    private final Condition entryAdded;

    public JobExecutor(PriorityQueue<Job> jobPriorityQueue, Lock queueLock, Condition entryAdded, int threadCount) {
        this.entryAdded = entryAdded;
        this.jobPriorityQueue = jobPriorityQueue;
        this.queueLock = queueLock;
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public void run() {
        while (true) {
            queueLock.lock();
            try {
                if (!jobPriorityQueue.isEmpty()) {
                    Job job = jobPriorityQueue.peek();
                    Date currentDate = new Date(System.currentTimeMillis());

                    if (currentDate.compareTo(job.getStartTime()) >= 0) {
                        jobPriorityQueue.remove();
                        executorService.execute(job);
                    }
                } else {
                    try {
                        entryAdded.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
            } finally {
                queueLock.unlock();
            }
        }
    }
}
