package mk.ukim.finki.emt.OnlineStore.service.impl;

import mk.ukim.finki.emt.OnlineStore.model.Category;
import mk.ukim.finki.emt.OnlineStore.persistence.CategoryRepository;
import mk.ukim.finki.emt.OnlineStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);

        return categories;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
