package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_status")
public class BookingStatus {

    @Id
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "current_status")
    private String currentStatus;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "id_verified")
    private boolean idVerified;
}
