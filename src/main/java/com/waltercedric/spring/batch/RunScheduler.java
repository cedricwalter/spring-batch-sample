package com.waltercedric.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import java.util.UUID;

public class RunScheduler {

    private JobLauncher jobLauncher;

    private Job job;

    private JobExecution jobExecution;

    public void run() {
        try {
            try {
                //Log4j2 ThreadContext.put("tool", job.getName());
                System.out.println("RunScheduler starting Job " + job.getName() + ".");

                JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                        .addString("uuid", UUID.randomUUID().toString()).toJobParameters();
                jobExecution = jobLauncher.run(job, jobParameters);

                System.out.println("RunScheduler " + jobExecution.getStatus() + " finished successfully.");
            } finally {
                //Log4j2 ThreadContext.remove("tool");
            }
        } catch (Exception e) {
            System.err.println("Job " + job.getName() + " failed." + e);
        }


    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

}