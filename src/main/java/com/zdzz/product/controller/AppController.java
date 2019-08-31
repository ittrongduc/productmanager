package com.zdzz.product.controller;

import com.zdzz.product.model.Product;
import com.zdzz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){

//        List<Product> productList = productService.listAll();

//        model.addAttribute("productList", productList);

        return "index";
    }

}
