package com.ani.backend.response.property;

import lombok.Data;

@Data
public class PropertyThumbnailResponse {

    private int propertyId;

    private String buildingName;

    private String propertyType;

    private String location;

    private float rating;

    private float price;

    private String thumbnailImageUrl;

}
