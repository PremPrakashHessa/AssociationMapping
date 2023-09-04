package com.example.associationmapping.entities;

import com.example.associationmapping.comparators.ReverseStringComparator;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SortComparator;


import java.util.*;


@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ImagePath")
    @Column(name = "Path")
    @MapKeyColumn(name ="Item_key")
    @SortComparator(ReverseStringComparator.class)
    private SortedMap<String,String> imagePaths = new TreeMap<>();

}
