package ua.goit.dev6.model.dao;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "customers")
public class CustomerDao {
    private Long id;
    private String name;
    private String descriptions;

    public CustomerDao() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDao that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(descriptions, that.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptions);
    }

}
