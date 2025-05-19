package com.rentalmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "landlords")
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String businessAddress;

    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Property> properties;

    @OneToMany(mappedBy = "landlord", cascade = CascadeType.ALL)
    private List<Lease> leases;
}
