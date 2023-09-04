package com.example.associationmapping;

import com.example.associationmapping.entities.Item;
import com.example.associationmapping.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SortedMapTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testSortedMapOrder (){
        Item item = new Item();
        item.setName("Painting");

        SortedMap<String,String> sm =new TreeMap<>();
        sm.put("first","MonaLisa");
        sm.put("second","Portrait of a Lady On Fire");
        sm.put("third","Boston Tea Party");
        sm.put("fourth","Jesus with Angels");

        item.setImagePaths(sm);

        itemRepository.save(item);

        Optional<Item> byName = itemRepository.findByName(item.getName());
        byName.ifPresent(
                (retrievedItem)->
                    assertAll(
                            ()-> assertEquals("third",retrievedItem.getImagePaths().firstKey()),
                            ()-> assertEquals("first",retrievedItem.getImagePaths().lastKey(),"last key mismatches")
                    ) //assertAll
        );//ifPresent
    }
}
