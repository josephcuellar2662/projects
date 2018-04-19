package com.revature.projectthree.skill.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SKILL_TYPE")
public class SkillType {
    @Id
    @Column(name = "SKILL_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillTypeId;

    @Column(name = "SKILL_TYPE_NAME")
    private String skillTypeName;

    @Column(name = "SKILL_TYPE_DESC")
    private String skillTypeDesc;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "IS_CORE")
    private boolean isCore;

    @ManyToMany(mappedBy = "skillTypeList")
    private Set<Skill> skillList;

    public SkillType() {
        super();
    }

    public SkillType(String skillTypeName, String skillTypeDesc, boolean isActive, boolean isCore, Set<Skill> skillList) {
        this.skillTypeName = skillTypeName;
        this.skillTypeDesc = skillTypeDesc;
        this.isActive = isActive;
        this.isCore = isCore;
        this.skillList = skillList;
    }

    public int getSkillTypeId() {
        return skillTypeId;
    }

    public void setSkillTypeId(int skillTypeId) {
        this.skillTypeId = skillTypeId;
    }

    public String getSkillTypeName() {
        return skillTypeName;
    }

    public void setSkillTypeName(String skillTypeName) {
        this.skillTypeName = skillTypeName;
    }

    public String getSkillTypeDesc() {
        return skillTypeDesc;
    }

    public void setSkillTypeDesc(String skillTypeDesc) {
        this.skillTypeDesc = skillTypeDesc;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCore() {
        return isCore;
    }

    public void setCore(boolean core) {
        isCore = core;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

}
