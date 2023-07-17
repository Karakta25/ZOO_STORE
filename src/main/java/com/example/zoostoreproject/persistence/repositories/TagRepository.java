package com.example.zoostoreproject.persistence.repositories;

import com.example.zoostoreproject.persistence.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {


}
