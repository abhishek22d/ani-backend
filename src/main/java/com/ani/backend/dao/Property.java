package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @Column(name = "property_id")
    private int propertyId;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "balcony")
    private int balcony;

    @Column(name = "bathrooms")
    private int bathrooms;

    @Column(name = "bedrooms")
    private int bedrooms;

    @Column(name = "description")
    private String description;

    @Column(name = "flat_no")
    private String flatNo;

    @Column(name = "kitchen")
    private int kitchen;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "title")
    private String title;

    @Column(name = "building_id")
    private int buildingId;

}
