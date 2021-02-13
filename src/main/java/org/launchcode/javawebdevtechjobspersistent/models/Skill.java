package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {



    @NotBlank(message ="Description is required")
    //@Size(min = 3, max= 255, message= "Skill description must be between 3 and 255 characters")
    private String description;


    //@JoinColumn(name="employer_id")
    @ManyToMany (mappedBy ="skills")
    private final List<Job> jobs = new ArrayList<>();

    public Skill(){};

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }




}