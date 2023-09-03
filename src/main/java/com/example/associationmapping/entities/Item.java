package com.example.associationmapping.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.type.descriptor.java.BasicJavaType;
import org.hibernate.type.descriptor.java.LongJavaType;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "ImagePath")
    @GenericGenerator(name = "image_gen" , strategy = "sequence")
    @Column(name = "Path")
    @CollectionId(
            column = @Column(name = "Image_id"),
            generator = "image_gen"
    )
    @CollectionIdJavaType(LongJavaType.class)
    private Collection<String> imagePaths = new ArrayList<>();

}
