package com.codegym.model.bean.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "serviceType")
    private List<Service> services;

    public ServiceType() {
    }

    public ServiceType(Long id, String name, List<Service> services) {
        this.id = id;
        this.name = name;
        this.services = services;
    }
}
