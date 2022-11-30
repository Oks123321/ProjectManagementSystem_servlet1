package ua.goit.dev6.model.dao;

import jakarta.persistence.*;
import ua.goit.dev6.model.SkillLevel;

import java.util.Objects;
import java.util.Set;

@Entity
    @Table(name = "skills")
public class SkillDao {
    private Long id;
    private String language;
    private SkillLevel level;
    Set<DeveloperDao> developers;

    public SkillDao() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "language", length = 50)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkillDao skillDao)) return false;
        return Objects.equals(id, skillDao.id) && Objects.equals(language, skillDao.language) && level == skillDao.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, level);
    }

    @ManyToMany(mappedBy = "skills")
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }

}
