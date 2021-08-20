package model.service.impl;

import model.bean.Category;
import model.repository.ICategoryRepository;
import model.repository.impl.CategoryRepositoryImpl;
import model.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> selectAll() {
        return this.categoryRepository.selectAll();
    }
}
