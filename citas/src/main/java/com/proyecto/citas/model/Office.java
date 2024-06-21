package com.proyecto.citas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @ManyToMany
    @JoinTable(
        name = "office_medic",
        joinColumns = @JoinColumn(name = "office_id"),
        inverseJoinColumns = @JoinColumn(name = "medic_id")
    )
    
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
