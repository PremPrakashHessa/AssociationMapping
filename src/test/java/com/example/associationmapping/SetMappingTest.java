package com.example.associationmapping;

import com.example.associationmapping.entities.Item;
import com.example.associationmapping.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SetMappingTest {

    @Autowired
    private ItemRepository repo;

    @Test
    public void testPersistenceOfSetCollectionWithDuplicates(){

        Item item = new Item();
        item.setName("Apple");
        Set<String> paths = new HashSet<>();
        paths.add("apple.jpg");
        paths.add("Apple.jpg");
        paths.add("RedGreenPie.jpg");
        // on adding duplicate element , doesn't throw any exception , does not persist the item .
        paths.add("apple.jpg");
        item.setImagePaths(paths);

        repo.save(item);
    }
}
