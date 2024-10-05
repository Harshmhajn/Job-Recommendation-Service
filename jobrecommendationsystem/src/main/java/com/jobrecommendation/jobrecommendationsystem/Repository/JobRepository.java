package com.jobrecommendation.jobrecommendationsystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobrecommendation.jobrecommendationsystem.Model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
