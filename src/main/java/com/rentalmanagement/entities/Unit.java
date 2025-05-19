package com.rentalmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String unitNumber;

    @Column(nullable = false)
    private Integer numberOfBedrooms;

    @Column(nullable = false)
    private Integer numberOfBathrooms;

    @Column(nullable = false)
    private BigDecimal monthlyRent;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant currentTenant;
}
