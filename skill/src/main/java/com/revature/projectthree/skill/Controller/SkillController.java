package com.revature.projectthree.skill.Controller;


import com.revature.projectthree.skill.Model.Skill;

import java.util.List;

public interface SkillController {

    Skill save(Skill skill);

    Skill findById(int id);

    List<Skill> findBySkillTypeId(int id);

    List<Skill> findAll();

    void update(Skill updateSkill);

    void delete(Skill s);

}
