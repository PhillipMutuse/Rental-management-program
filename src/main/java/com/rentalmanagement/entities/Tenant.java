package com.rentalmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tenants")
public class Tenant {
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
    private Date dateOfBirth;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<RentPayment> payments;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Lease> leases;
}
