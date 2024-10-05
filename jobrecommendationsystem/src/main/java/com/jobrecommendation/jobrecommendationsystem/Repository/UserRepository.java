package com.jobrecommendation.jobrecommendationsystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobrecommendation.jobrecommendationsystem.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
