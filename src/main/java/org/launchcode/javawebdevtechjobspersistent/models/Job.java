package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
//public class Job{

    //public class Employer extends AbstractEntity {
    @Entity
    public class Job extends AbstractEntity{

    //@Id
    //@GeneratedValue
    //private int id;

    //private String name;


    @ManyToOne
    @NotNull(message ="Category is required")
    private Employer employer;
    private String skills;

    public Job() {
    }

    //public Job(String anEmployer, String someSkills) {
      public Job(String someSkills, Employer employer) {
        super();
        //this.employer = anEmployer;
          this.employer = employer;
        this.skills = someSkills;
    }

    // Getters and setters.

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

        public Employer getEmployer() { //added after updating String to Employer
            return employer;
        }

        public void setEmployer(Employer employer) {//added after updating String to Employer
            this.employer = employer;
        }
}
