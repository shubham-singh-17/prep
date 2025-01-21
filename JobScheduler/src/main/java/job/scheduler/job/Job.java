package job.scheduler.job;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import job.scheduler.enums.TaskType;
import job.scheduler.service.SchedulerService;

public class Job implements Runnable, Comparable<Job> {

    private final UUID jobId;
    private final Runnable task;
    private final Date startTime;
    private final TimeUnit timeUnit;
    private final int delay;
    private final TaskType taskType;

    public Job(Runnable task, Date startTime) {
        this.jobId = UUID.randomUUID();
        this.task = task;
        this.startTime = startTime;
        this.timeUnit = TimeUnit.SECONDS;
        this.delay = -1;
        this.taskType = TaskType.ONCE;
    }

    public Job(Runnable task, Date startTime, int delay, TimeUnit timeUnit, TaskType taskType) {
        this.jobId = UUID.randomUUID();
        this.task = task;
        this.startTime = startTime;
        this.timeUnit = timeUnit;
        this.delay = delay;
        this.taskType = taskType;
    }

    public Date getStartTime() {
        return startTime;
    }

    @Override
    public int compareTo(Job o) {
        return this.startTime.compareTo(o.startTime);
    }

    @Override
    public void run() {
        if (taskType == TaskType.REPEAT_FIXED_RATE) {
            SchedulerService.getInstance().scheduleAtFixedRate(task, delay, delay, timeUnit);
        }

        try {
            task.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (taskType == TaskType.REPEAT_FIXED_DELAY) {
                SchedulerService.getInstance().scheduleAtFixedRateWithTaskTime(task, delay, delay, timeUnit);
            }
        }
    }
}
