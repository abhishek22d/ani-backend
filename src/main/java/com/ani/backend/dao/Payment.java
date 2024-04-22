package com.ani.backend.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "mode_of_payment")
    private String modeOfPayment;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "amount_received")
    private float amountReceived;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "transaction_id")
    private String transactionId;
}
