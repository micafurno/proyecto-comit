package com.mica.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mica.tienda.entidades.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
