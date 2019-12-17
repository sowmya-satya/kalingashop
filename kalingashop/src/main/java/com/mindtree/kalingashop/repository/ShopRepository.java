package com.mindtree.kalingashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingashop.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
