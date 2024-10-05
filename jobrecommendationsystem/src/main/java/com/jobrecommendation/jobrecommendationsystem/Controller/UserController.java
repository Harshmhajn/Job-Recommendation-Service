package com.jobrecommendation.jobrecommendationsystem.Controller;
import com.jobrecommendation.jobrecommendationsystem.Model.Job;
import com.jobrecommendation.jobrecommendationsystem.Service.JobRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jobrecommendation.jobrecommendationsystem.Model.User;
import com.jobrecommendation.jobrecommendationsystem.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private JobRecommendationService jobRecommendationService;
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addAll")
    public List<User> createUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }
    @GetMapping("/getRecommendation/{id}")
    public ResponseEntity<List<Job>> getJobRecommendations(@PathVariable Long id){
        User user = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        List<Job> recommendedJobs = jobRecommendationService.getRecommendedJobs(user);
        return ResponseEntity.ok(recommendedJobs);
    }
}
