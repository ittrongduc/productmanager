package com.zdzz.product.controller;

import com.zdzz.product.model.Product;
import com.zdzz.product.service.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productDAO.getAllProduct();
    }

    @RequestMapping(value = "/product/{_id}", method = RequestMethod.GET)
    public Optional<Product> getProductById(@PathVariable("_id") String _id){
        return productDAO.findById(_id);
    }

    @RequestMapping(value = "/product/insert", method = RequestMethod.POST)
    public Product insertProduct(@RequestBody Product product){
        return productDAO.saveProduct(product);
    }

    @RequestMapping(value = "/product/delete/{_id}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable("_id") String _id){
        return productDAO.deleteProduct(_id);
    }

    @RequestMapping(value = "/product/update/{_id}", method = RequestMethod.POST)
    public Product updateProduct(@PathVariable("_id") String _id, @RequestBody Product product){
        return productDAO.updateProduct(_id, product);
    }

}
