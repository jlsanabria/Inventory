package tech.icei.product.dao;

import tech.icei.product.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryDAO {
    // CRUD Category

    boolean createCategory(Category category);

    List<Category> readCategories(String criteria);

    Category updateCategory(Category category);

    boolean deleteCategory(Category category);

    void addCategory(Category category);
}
