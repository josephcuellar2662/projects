package com.revature.projectthree.skill.Service;

import com.revature.projectthree.skill.Model.Skill;

import java.util.List;

public interface SkillService {

    public Skill save(Skill newSkill);

    public Skill findById(int id);

    public List<Skill> findBySkillTypeId(int id);

    public List<Skill> findAll();

    public void update(Skill updateSkill);

    public void delete(Skill s);
}
