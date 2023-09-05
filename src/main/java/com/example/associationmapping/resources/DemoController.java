package com.example.associationmapping.resources;

import com.example.associationmapping.entities.Image;
import com.example.associationmapping.entities.Item;
import com.example.associationmapping.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DemoController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/saveItem")
    public String persistItem(){
        Item item= new Item();
        Item item2 = new Item();
        item.setName("A");
        Map<String , Image> s = new HashMap<>();
        s.put("App",new Image("App","Apple",5,6));
        s.put("Ban",new Image("Ban","Banana",5,6));
        s.put("Pap",new Image("Pap","Papaya",5,6));
        s.put("Parr",new Image("Parr","Parrot",5,6));
        item.setImages(s);
        itemRepository.save(item);

        item2.setName("B");
        item2.setImages(s);
        itemRepository.save(item2);

       return "";
    }
}
