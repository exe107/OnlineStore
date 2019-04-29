package mk.ukim.finki.emt.OnlineStore.service;

import mk.ukim.finki.emt.OnlineStore.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    void saveCategory(Category category);
}
