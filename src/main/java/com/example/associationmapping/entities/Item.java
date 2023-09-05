package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OrderBy;
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
    @CollectionTable(name = "Images")
    @MapKeyColumn(name = "TIt")
    private Map<String,Image> images = new HashMap<>();


}
