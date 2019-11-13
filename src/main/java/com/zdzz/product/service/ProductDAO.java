package com.zdzz.product.service;

import com.zdzz.product.model.Product;
import com.zdzz.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        if (Objects.isNull(product)){
            return new Product();
        }
        return productRepository.insert(product);
    }

    public Product updateProduct(String _id, Product productNew){
        if (Objects.isNull(productNew) && Objects.isNull(productNew.getId())){
            return new Product();
        }
        //Get the old product by _id
        Optional<Product> productOld = findById(_id);
        if (Objects.nonNull(productOld)){
            //Set the new product _id by old product _id
            productNew.setId(productOld.get().getId());
            //update product with old _id
            return productRepository.save(productNew);
        }
        return new Product();
    }

    public String deleteProduct(String _id){
        //Get product by _id
        Optional<Product> prod = findById(_id);
        if (Objects.nonNull(prod.get())){
            //update product with old _id
            productRepository.delete(prod.get());
        }
        return String.format("Product with id: %s has been removed", _id);
    }

    public Optional<Product> findById(String _id){
        return productRepository.findById(_id);
    }
}
