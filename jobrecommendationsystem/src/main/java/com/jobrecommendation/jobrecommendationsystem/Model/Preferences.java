package com.jobrecommendation.jobrecommendationsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter
@Setter
public class Preferences {

    @ElementCollection
    @CollectionTable(name = "desired_roles", joinColumns = @JoinColumn(name = "user_id")) // Ensure this is correct
    @Column(name = "role")
    private List<String> desiredRoles;

    @ElementCollection
    @CollectionTable(name = "preferred_locations", joinColumns = @JoinColumn(name = "user_id")) // Ensure this is correct
    @Column(name = "location")
    private List<String> locations;

    @Column(name = "job_type", nullable = false)
    private String jobType;

    public List<String> getDesiredRoles() {
        return desiredRoles;
    }

    public void setDesiredRoles(List<String> desiredRoles) {
        this.desiredRoles = desiredRoles;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

}
