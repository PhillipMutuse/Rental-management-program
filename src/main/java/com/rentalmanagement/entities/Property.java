package com.rentalmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer numberOfUnits;

    @Column(nullable = false)
    private String amenities;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Unit> units;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<MaintenanceRequest> maintenanceRequests;
}
