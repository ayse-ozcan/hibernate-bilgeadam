package com.ayseozcan.repository;

import com.ayseozcan.entity.Category;
import com.ayseozcan.utility.MyFactoryRepository;

public class CategoryRepository extends MyFactoryRepository<Category, Long> {

    public CategoryRepository(){
        super(new Category());
    }
}
