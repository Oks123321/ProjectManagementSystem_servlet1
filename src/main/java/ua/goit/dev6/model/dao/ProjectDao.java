package ua.goit.dev6.model.dao;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
@Entity
@Table(name = "projects")
public class ProjectDao {
    private Long id;
    private String name;
    private String descriptions;
    private int cost;
    private Long date;

    private Set<DeveloperDao> developers;

    public ProjectDao() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "descriptions", length = 200)
    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Column(name = "date")
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDao that)) return false;
        return cost == that.cost && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(descriptions, that.descriptions) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptions, cost, date);
    }

    @ManyToMany(mappedBy = "projects")
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }
}
