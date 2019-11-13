package com.zdzz.product.service;

import com.zdzz.product.model.Product;
import com.zdzz.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
