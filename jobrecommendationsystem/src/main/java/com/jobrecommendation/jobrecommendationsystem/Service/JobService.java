package com.jobrecommendation.jobrecommendationsystem.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobrecommendation.jobrecommendationsystem.Model.Job;
import com.jobrecommendation.jobrecommendationsystem.Repository.JobRepository;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job job) {
        job.setId(id);
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> createJobs(List<Job> jobs) {
        return jobRepository.saveAll(jobs);
    }
}

