package com.example.zoostoreproject.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "multimedia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Multimedia {

   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   @Column(name = "id")
    private UUID id;

    @Column(name = "url", nullable = false, unique = true)
    @Getter
    private String url;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
}
