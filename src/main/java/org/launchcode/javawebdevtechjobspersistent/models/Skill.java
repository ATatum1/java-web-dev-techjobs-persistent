package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message ="Skill description is required")
    //@Size(min = 3, max= 255, message= "Skill description must be between 3 and 255 characters")
    private String skillDescription;

    public Skill(String skillDescription){
        this.skillDescription = skillDescription;
    }

    public Skill(){};



    public String getSkill() {
        return skillDescription;
    }

    public void setSkill(String skillDescription) {
        this.skillDescription = skillDescription;
    }

}