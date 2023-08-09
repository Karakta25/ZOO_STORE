package com.example.zoostoreproject.persistence.repositories;

import com.example.zoostoreproject.persistence.entities.Item;
import com.example.zoostoreproject.persistence.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    Page<Item> findItemsByTagsContaining(Tag tag, Pageable pageable);
    @Query(value = """
            SELECT *
            FROM items i
            WHERE i.description REGEXP :regex
            ORDER BY description ASC
            """, nativeQuery = true)
    Page<Item> findAllItemsByDescription(String regex, Pageable pageable);
}
