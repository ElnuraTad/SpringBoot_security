package com.peaksoft.springboot_security.service;

import com.peaksoft.springboot_security.entity.Product;
import com.peaksoft.springboot_security.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return  productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product getById(Long id){
        return productRepository.findById(id).get();
    }

    public  void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
