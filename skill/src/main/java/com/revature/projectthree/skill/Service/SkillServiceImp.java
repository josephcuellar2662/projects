package com.revature.projectthree.skill.Service;

import com.revature.projectthree.skill.Model.Skill;
import com.revature.projectthree.skill.Repository.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImp implements SkillService {


    private final SkillRepo skillRepo;

    @Autowired
    public SkillServiceImp(SkillRepo skillRepo) {
        super();
        this.skillRepo = skillRepo;
    }

    @Override
    public Skill save(Skill newSkill) {
        return skillRepo.save(newSkill);
    }

    @Override
    public Skill findById(int id) {
        return skillRepo.findBySkillId(id);
    }

    @Override
    public List<Skill> findBySkillTypeId(int id) {
        return null;
    }

    @Override
    public List<Skill> findAll() {
        return skillRepo.findAll();
    }

    @Override
    public void update(Skill updateSkill) {
        this.skillRepo.save(updateSkill);
    }

    @Override
    public void delete(Skill s) {
        this.skillRepo.delete(s);
    }
}
