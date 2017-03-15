package yitian.study.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzService implements IService, Job {
    @Override
    public void doService() {
        System.out.println("This is a quartz service");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Do something in execute method of quartz");
    }
}
