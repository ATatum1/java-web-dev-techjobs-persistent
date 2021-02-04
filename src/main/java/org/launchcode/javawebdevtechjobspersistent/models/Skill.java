package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message ="Description is required")
    //@Size(min = 3, max= 255, message= "Skill description must be between 3 and 255 characters")
    private String description;

    public Skill(String description){
        this.description = description;
    }

    public Skill(){};



    public String getSkill() {
        return description;
    }

    public void setSkill(String skillDescription) {
        this.description = description;
    }

}