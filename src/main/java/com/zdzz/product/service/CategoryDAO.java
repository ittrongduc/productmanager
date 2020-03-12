package com.zdzz.product.service;

import com.zdzz.product.model.Category;
import com.zdzz.product.model.User;
import com.zdzz.product.repository.CategoryRepository;
import com.zdzz.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryDAO {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategorys(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        if (Objects.isNull(category)){
            return new Category();
        }
        return categoryRepository.insert(category);
    }

    public Category updateCategory(String _id, Category categoryNew){
        if (Objects.isNull(categoryNew) && Objects.isNull(categoryNew.getId())){
            return new Category();
        }
        Optional<Category> categoryOld = findById(_id);
        if (Objects.nonNull(categoryOld)){
            categoryNew.setId(categoryOld.get().getId());
            return categoryRepository.save(categoryNew);
        }
        return new Category();
    }

    public String deleteCategory(String _id){
        Optional<Category> category = findById(_id);
        if (Objects.nonNull(category.get())){
            categoryRepository.delete(category.get());
        }
        return String.format("Category with id: %s has been removed", _id);
    }

    public Optional<Category> findById(String _id){
        return categoryRepository.findById(_id);
    }
}
