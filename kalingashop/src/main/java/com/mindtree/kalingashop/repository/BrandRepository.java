package com.mindtree.kalingashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingashop.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
