package com.peaksoft.springboot_security.repository;

import com.peaksoft.springboot_security.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long > {

    @Override
    List<Product> findAll();

    @Override
    <S extends Product> S save(S entity);

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
