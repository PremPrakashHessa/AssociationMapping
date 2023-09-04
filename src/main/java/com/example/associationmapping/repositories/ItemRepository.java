package com.example.associationmapping.repositories;

import com.example.associationmapping.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i inner join fetch i.imagePaths where i.id = :id")
    Item findWithImages(@Param("id") Long id);

    @Query(value = "SELECT PATH FROM IMAGEPATH WHERE ITEM_ID = ?1" , nativeQuery = true)
    Set<String> getImagePathsOfItem(Long id);

    @Query("select i from Item i where i.name = :name")
   Optional<Item> findByName( @Param("name") String name);


}