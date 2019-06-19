package net.stevenking.apartment.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class ApartmentTrigger {
    JobDetail job = JobBuilder.newJob(ApartmentJob.class)
            .withIdentity("dummyJobName", "group1").build();

    // Trigger the job to run on the next round minute
    Trigger trigger = TriggerBuilder
            .newTrigger()
            .withIdentity("dummyTriggerName", "group1")
            .withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(5).repeatForever())
            .build();


    // schedule it
    Scheduler scheduler;

    {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
