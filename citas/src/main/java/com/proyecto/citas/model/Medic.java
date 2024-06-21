package com.proyecto.citas.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "medics")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "office_medic",
        joinColumns = @JoinColumn(name = "medic_id"),
        inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private List<Office> offices;
    
    @ManyToMany
    @JoinTable(
        name = "medic_category",
        joinColumns = @JoinColumn(name = "medic_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    // Getters and Setters

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
