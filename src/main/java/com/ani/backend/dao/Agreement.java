package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "agreement")
public class Agreement {

    @Column(name = "agreement_id")
    private int agreementId;

    @Column(name = "building_id")
    private int buildingId;

    @Column(name = "listing_status")
    private String listingStatus;

    @Column(name = "listing_date")
    private LocalDate listingDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "agreement_link")
    private String agreementLink;
}
