package com.revature.projectthree.skill.Repository;

import com.revature.projectthree.skill.Model.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepo extends JpaRepository <SkillType, Integer> {

}
