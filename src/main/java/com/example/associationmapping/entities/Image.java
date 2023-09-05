package com.example.associationmapping.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Parent;

@Embeddable
@Data
@NoArgsConstructor
public class Image {

    public Image(String fileName,int height,int width){
        this.fileName = fileName;
        this.height = height;
         this.width = width;
    }

    // doesn't work as expected
    /*@Parent
    public Item item;*/

    @Column(nullable = false)
    private String fileName;
    private int height;
    private int width;



}
