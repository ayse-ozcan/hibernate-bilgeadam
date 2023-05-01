package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Category;
import com.ayseozcan.service.CategoryService;

public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(){
        this.categoryService = new CategoryService();
    }

    public void save(){
        String categoryName = BAUtils.readString("category name: ");
        Category category = new Category();
        category.setName(categoryName);
        categoryService.save(category);
    }
}
