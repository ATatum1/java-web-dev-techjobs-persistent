package org.launchcode.javawebdevtechjobspersistent.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {




    @NotBlank(message ="Location is required")
    @Size(min = 2, max= 255, message= "Location must be between 3 and 255 characters")
    private String location;

//    @NotBlank(message ="Name is required")
//    @Size(min = 2, max= 255, message= "Name must be between 2 and 255 characters")
//    private String name;

    @JoinColumn(name="employer_id")
    @OneToMany()
    private final List<Job> jobs = new ArrayList<>();


    public Employer(){}


    public Employer(String location) {
        this.location = location;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<Job> getJobs() {
        return jobs;
    }

//    public void setJobs(List<Job> jobs) {
//        this.jobs = jobs;
//    }



}
