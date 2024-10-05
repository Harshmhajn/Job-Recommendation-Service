package com.jobrecommendation.jobrecommendationsystem.Service;

import com.jobrecommendation.jobrecommendationsystem.Model.Job;
import com.jobrecommendation.jobrecommendationsystem.Model.User;
import com.jobrecommendation.jobrecommendationsystem.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobRecommendationService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getRecommendedJobs(User user){
        List<Job> allJobs = jobRepository.findAll();
        List<Job> match = new ArrayList<>();
        for(Job job : allJobs){
            if(calculateScore(user,job) > 100){
                match.add(job);
            }
        }
        return  match;
    }
    public int calculateScore(User user,Job job){
        int score = 0;
        for(String userSkills: user.getSkills()){
            for(String requiredSkills : job.getSkillsRequired()){
                if(userSkills.equalsIgnoreCase(requiredSkills)){
                    score+=15;
                }
            }
        }
        if (job.getExperienceLevel().equalsIgnoreCase(user.getExperienceLevel())) {
            score += 40;
        }else{
            return 0;
        }
        if(user.getPreferences().getLocations().contains(job.getLocation())){
            score += 40;
        }

        if (job.getJobType().equalsIgnoreCase(user.getPreferences().getJobType())){
            score += 40;
        }

        if (user.getPreferences().getDesiredRoles().stream()
                .anyMatch(role -> job.getTitle().contains(role))) {
            score += 20;
        }

        return score;
    }
}
