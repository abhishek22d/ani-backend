package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "amenity")
public class Amenity {

    @Column(name = "amenity_id")
    private int amenityId;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "category")
    private String category;
}
