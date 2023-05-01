package com.ayseozcan.service;

import com.ayseozcan.entity.Category;
import com.ayseozcan.repository.CategoryRepository;
import com.ayseozcan.utility.MyFactoryService;

public class CategoryService extends MyFactoryService<CategoryRepository, Category, Long> {

    public CategoryService(){
        super(new CategoryRepository());
    }
}
