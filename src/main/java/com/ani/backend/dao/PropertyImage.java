package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "property_image")
public class PropertyImage {

    @Column(name = "property_image_id")
    private int propertyImageId;

    @Column(name = "property_id")
    private int propertyId;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "image_type")
    private String image_type;

    @Column(name = "order")
    private String order;

    @Column(name = "category")
    private String category;
}
