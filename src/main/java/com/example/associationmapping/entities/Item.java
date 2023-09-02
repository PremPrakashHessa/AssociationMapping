package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "ImagePath",
            joinColumns = @JoinColumn(name = "Item_id")
    )
    @Column(name = "Path")
    private Set<String> imagePaths = new HashSet<>();

}
