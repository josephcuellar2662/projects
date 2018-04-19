package com.revature.projectthree.skill.Repository;

import com.revature.projectthree.skill.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepo extends JpaRepository<Skill, Integer> {

    Skill findBySkillId(int id);

    List<Skill> findAll();



}
