package com.example.springbootfish.model;

import javax.persistence.*;

@Entity
@Table(name="fishes")
public class Fish{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="family_name")
    private String familyName;

    @Column(name="long_size")
    private Long longSize;

    @Column(name="color")
    private String color;

    @Column(name="water_type")
    private String waterType;

    @Column(name="water_temperature")
    private String waterTemperature;

    @Column(name="alive")
    private Boolean alive;

    public Fish() {
    }

    public Fish(String familyName, Long longSize, String color, String waterType, String waterTemperature, Boolean alive) {
        this.familyName = familyName;
        this.longSize = longSize;
        this.color = color;
        this.waterType = waterType;
        this.waterTemperature = waterTemperature;
        this.alive = alive;
    }

    public Long getId() {
        return id;
    }

    public Fish setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Fish setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Long getSize() {
        return longSize;
    }

    public Fish setSize(Long size) {
        this.longSize = size;
        return this;
    }

    public String getQuantity() {
        return color;
    }

    public Fish setQuantity(String color) {
        this.color = color;
        return this;
    }

    public String getWaterType() {
        return waterType;
    }

    public Fish setWaterType(String waterType) {
        this.waterType = waterType;
        return this;
    }

    public String getWaterTemperature() {
        return waterTemperature;
    }

    public Fish setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature;
        return this;
    }

    public Boolean getAlive() {
        return alive;
    }

    public Fish setAlive(Boolean alive) {
        this.alive = alive;
        return this;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", size=" + longSize +
                ", quantity=" + color + '\'' +
                ", waterType='" + waterType + '\'' +
                ", waterTemperature='" + waterTemperature + '\'' +
                ", alive=" + alive +
                '}';
    }
}
