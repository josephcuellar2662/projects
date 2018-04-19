package com.revature.projectthree.skill.Controller;

import com.revature.projectthree.skill.Model.SkillType;

import java.util.List;

public interface SkillTypeController {

    SkillType save(SkillType newSkillType);

    SkillType findById(int id);

    List<SkillType> findBySkillId(int id);

    List<SkillType> findAll();

    void update(SkillType updateSkillType);

    void delete(int id);

}
