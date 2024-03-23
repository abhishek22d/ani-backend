package com.ani.backend.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Test")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
