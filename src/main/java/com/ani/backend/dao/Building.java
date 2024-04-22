package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "building")
public class Building {

    @Column(name = "building_id")
    private int buildingId;

    @Column(name = "location")
    private String location;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private int pincode;

    @Column(name = "nearby_attractions")
    private String nearby_attractions;
}
