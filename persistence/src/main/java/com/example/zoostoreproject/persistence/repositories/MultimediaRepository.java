package com.example.zoostoreproject.persistence.repositories;

import com.example.zoostoreproject.persistence.entities.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MultimediaRepository extends JpaRepository<Multimedia, UUID> {



}
