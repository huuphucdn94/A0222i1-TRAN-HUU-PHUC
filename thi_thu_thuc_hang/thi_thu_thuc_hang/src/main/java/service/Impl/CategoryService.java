package service.Impl;


import modle.Category;
import repository.ICategoryRepository;
import repository.Impl.CategoryRepository;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findListCategory() {
        return categoryRepository.findListCategory();
    }
}
