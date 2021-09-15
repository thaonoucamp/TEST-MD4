package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Country country;
    private long area;
    private long population;
    private long gdp;
    private String description;

    public City() {
    }

    public City(Long id, String name, Country country, long area, long population, long gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", area=" + area +
                ", population=" + population +
                ", gdp=" + gdp +
                ", description='" + description + '\'' +
                '}';
    }
}
