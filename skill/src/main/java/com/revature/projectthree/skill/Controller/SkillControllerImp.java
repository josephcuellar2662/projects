package com.revature.projectthree.skill.Controller;

import com.revature.projectthree.skill.Model.Skill;
import com.revature.projectthree.skill.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "skills")
public class SkillControllerImp implements  SkillController{

    private final SkillService skillService;

    @Autowired
    public SkillControllerImp(SkillService skillService) {
        this.skillService = skillService;
    }

    @Override
    public Skill save(Skill skill) {
        return this.skillService.save(skill);
    }

    @Override
    public Skill findById(int id) {
        return this.skillService.findById(id);
    }

    @Override
    public List<Skill> findBySkillTypeId(int id) {
        return null;
    }

    @Override
    public List<Skill> findAll() {
        return this.skillService.findAll();
    }

    @Override
    public void update(Skill updateSkill) {
        this.skillService.update(updateSkill);
    }

    @Override
    public void delete(Skill s) {
        this.skillService.delete(s);
    }
}
