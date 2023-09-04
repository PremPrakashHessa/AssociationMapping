package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SortNatural;

import java.util.*;


@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "ImagePath")
    @Column(name = "Path")
    @SortNatural
    private Set<String> imagePaths = new TreeSet<>();

}
