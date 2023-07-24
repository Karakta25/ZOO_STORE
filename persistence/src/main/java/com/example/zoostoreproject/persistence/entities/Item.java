package com.example.zoostoreproject.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "product name", nullable = false,unique = true)
    private String productName;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @Column(name = "multimedia")
    @OneToMany(mappedBy = "item")
    private Set<Multimedia> multimedia;

    @Column(name = "tag")
    @ManyToMany
    @JoinTable(
            name = "item_tag",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags;

    @Column(columnDefinition = "boolean default false")
    private boolean archived;

}
