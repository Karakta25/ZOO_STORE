package com.example.zoostoreproject.persistence.repositories;

import com.example.zoostoreproject.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {


}
