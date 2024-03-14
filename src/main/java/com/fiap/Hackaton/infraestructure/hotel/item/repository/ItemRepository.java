package com.fiap.Hackaton.infraestructure.hotel.item.repository;

import com.fiap.Hackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
