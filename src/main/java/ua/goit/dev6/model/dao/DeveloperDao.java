package ua.goit.dev6.model.dao;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "developers")
public class DeveloperDao {
    long id;
    String first_name;
    String last_name;
    int age;
    int salary;
    private Set<SkillDao> skills;
    private Set<ProjectDao> projects;

    public DeveloperDao() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "first_name", length = 200)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    @Column(name = "last_name", length = 200)
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeveloperDao that)) return false;
        return id == that.id && age == that.age && salary == that.salary && Objects.equals(first_name, that.first_name)
                && Objects.equals(last_name, that.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, age, salary);
    }

    @ManyToMany
    @JoinTable(
            name = "developers_skills_relation",
            joinColumns = {@JoinColumn(name = "developers_id")},
            inverseJoinColumns = {@JoinColumn(name = "skills_id")}
    )
    public Set<SkillDao> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDao> skills) {
        this.skills = skills;
    }

    @ManyToMany
    @JoinTable(
            name = "projects_developers_relation",
            joinColumns = {@JoinColumn(name = "developers_id")},
            inverseJoinColumns = {@JoinColumn(name = "projects_id")}
    )
    public Set<ProjectDao> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectDao> projects) {
        this.projects = projects;
    }
}
