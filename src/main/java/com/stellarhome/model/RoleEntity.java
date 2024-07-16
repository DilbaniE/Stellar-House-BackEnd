package com.stellarhome.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RoleEntity")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "codeRole", nullable = false)
    private String codeRole;
    @Column(name = "description", nullable = false)
    private String description;
}
