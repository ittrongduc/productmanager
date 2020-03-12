package com.zdzz.product.controller;

import com.zdzz.product.model.Category;
import com.zdzz.product.service.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public List<Category> getAllCategorys(){
        return categoryDAO.getAllCategorys();
    }

    @RequestMapping(value = "/category/{_id}", method = RequestMethod.GET)
    public Optional<Category> getCategoryById(@PathVariable("_id") String _id){
        return categoryDAO.findById(_id);
    }

    @RequestMapping(value = "/category/insert", method = RequestMethod.POST)
    public Category insertCategory(@RequestBody Category category){
        return categoryDAO.saveCategory(category);
    }

    @RequestMapping(value = "/category/delete/{_id}", method = RequestMethod.GET)
    public String removeCategory(@PathVariable("_id") String _id){
        return categoryDAO.deleteCategory(_id);
    }

    @RequestMapping(value = "/category/update/{_id}", method = RequestMethod.POST)
    public Category updateCategory(@PathVariable("_id") String _id, @RequestBody Category category){
        return categoryDAO.updateCategory(_id, category);
    }

}
