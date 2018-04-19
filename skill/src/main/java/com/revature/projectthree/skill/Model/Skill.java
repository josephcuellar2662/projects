package com.revature.projectthree.skill.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SKILL")
public class Skill {
    @Id
    @Column(name = "SKILL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "SKILL_ID_SEQ", sequenceName = "SKILL_ID_SEQ", allocationSize = 1)
    //@GeneratedValue(generator = "SKILL_ID_SEQ", strategy = GenerationType.AUTO)
    private int skillId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVE")
    private boolean active;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "SKILL_SKILLTYPE",
            joinColumns = {@JoinColumn(name = "SKILL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SKILL_TYPE_ID")})
    private List<SkillType> skillTypeList;

    public Skill() {
        super();
    }

    public Skill(String name, boolean active, List<SkillType> skillTypeList) {
        this.name = name;
        this.active = active;
        this.skillTypeList = skillTypeList;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<SkillType> getSkillTypeList() {
        return skillTypeList;
    }

    public void setSkillTypeList(List<SkillType> skillTypeList) {
        this.skillTypeList = skillTypeList;
    }

}
