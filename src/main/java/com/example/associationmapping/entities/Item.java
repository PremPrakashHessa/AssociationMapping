package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.java.BasicJavaType;
import org.hibernate.type.descriptor.java.LongJavaType;

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
    @MapKeyColumn(name = "imageKey")
    @Column(name = "Path")
    private Map<String,String> imagePaths = new HashMap<>();

}
