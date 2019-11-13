package com.zdzz.product.controller;

import com.zdzz.product.model.Product;
import com.zdzz.product.service.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/asdasd", method = RequestMethod.GET)
    public List<Product> getAllProducts(){

        return productDAO.getAllProduct();
    }

}
