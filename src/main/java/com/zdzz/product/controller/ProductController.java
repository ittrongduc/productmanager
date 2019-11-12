package com.zdzz.product.controller;

import com.zdzz.product.service.ProductDAO;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/product/getAll", method = RequestMethod.GET)
    public Set<Document> getAllProducts(){

        return productDAO.getAllProducts();
    }

}
