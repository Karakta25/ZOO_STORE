package com.example.zoostoreproject.persistence.repositories;

import com.example.zoostoreproject.persistence.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor,UUID> {


}
