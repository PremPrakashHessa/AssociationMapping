package com.example.associationmapping.controller;

import com.example.associationmapping.entities.Item;
import com.example.associationmapping.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

@RestController
public class DemoController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public void persistItems(){
        Item item = new Item();
        item.setName("Painting");

        SortedMap<String,String> sm =new TreeMap<>();
        sm.put("first","MonaLisa");
        sm.put("second","Portrait of a Lady On Fire");
        sm.put("third","Boston Tea Party");
        sm.put("fourth","Jesus with Angels");

        item.setImagePaths(sm);

        itemRepository.save(item);
    }

    @GetMapping("/imagepaths")
    public String getImagePaths(){
        Optional<Item> painting = itemRepository.findByName("Painting");
        painting.ifPresent(item -> System.out.println(item.getImagePaths()));
        return painting.get().getImagePaths().toString();
    }

}
