package com.JuniorDevTestTask.repository;

import com.JuniorDevTestTask.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<Item, Long> {
}
