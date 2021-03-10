package com.ItemsBackEnd.repository;

import com.ItemsBackEnd.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
