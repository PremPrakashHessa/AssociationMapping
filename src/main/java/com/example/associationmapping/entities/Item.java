package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.java.BasicJavaType;
import org.hibernate.type.descriptor.java.LongJavaType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "ImagePath")
    @OrderColumn
    @Column(name = "Path")
    private List<String> imagePaths = new ArrayList<>();

}
