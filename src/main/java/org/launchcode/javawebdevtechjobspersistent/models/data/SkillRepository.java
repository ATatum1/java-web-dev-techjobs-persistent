package org.launchcode.javawebdevtechjobspersistent.models.data;

import org.springframework.stereotype.Repository;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface SkillRepository extends CrudRepository <Job, Integer> {

}
