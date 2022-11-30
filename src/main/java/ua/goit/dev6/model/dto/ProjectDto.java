package ua.goit.dev6.model.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectDto {
    private Long id;
    private String name;
    private String descriptions;
    private int cost;
    private LocalDate date;
    public ProjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectDto that)) return false;
        return cost == that.cost && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(descriptions, that.descriptions) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descriptions, cost, date);
    }



}
