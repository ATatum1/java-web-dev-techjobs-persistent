package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//@Entity
//public class Job{

    //public class Employer extends AbstractEntity {
    @Entity
    public class Job extends AbstractEntity{

    //@Id
    //@GeneratedValue
    //private int id;

    //private String name;


    @ManyToOne()
    private Employer employer;

    //@ManyToMany(mappedBy ="jobs")
    @ManyToMany()
    private  List<Skill> skills = new ArrayList<>();


    public Job() {
    }

        public Job(Employer employer, Skill skills) {
            this.employer = employer;

           // this.skills = skills;
        }

        // Getters and setters.

        public List<Skill> getSkills() {
            return skills;
        }




        public void setSkills(List<Skill> skills) {
            this.skills = skills;
        }

        public void addSkill(Skill skills){
            this.skills.add(skills);
        }

    public Employer getEmployer() { //added after updating String to Employer
            return employer;
        }

    public void setEmployer(Employer employer) {//added after updating String to Employer
            this.employer = employer;
        }
}
