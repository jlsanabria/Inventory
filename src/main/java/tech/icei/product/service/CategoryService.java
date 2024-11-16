package tech.icei.product.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import tech.icei.product.dao.CategoryDAOImpl;
import tech.icei.product.dto.CategoryDTO;
import tech.icei.product.dto.CategoryRecord;
import tech.icei.product.enums.Status;
import tech.icei.product.model.Category;

import java.util.*;

@Slf4j
@Named
@ApplicationScoped
public class CategoryService {

    private CategoryDAOImpl categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    public boolean addCategory(Category category) {
        //category.setCategoryId(UUID.randomUUID());
        category.setStatus(Status.ACT);
        category.setCreatedAt(new Date());
        category.setCreatedBy("Admin");
        return categoryDAO.createCategory(category);
    }

    public List<CategoryRecord> listCategories(String criteria) {
        List<CategoryRecord> recordsCategory = new ArrayList<>();
        List<Category> categories = categoryDAO.readCategories(criteria);
        categories
                .forEach(category -> {
                    CategoryRecord categoryRecord = CategoryRecord
                            .builder()
                            .name(category.getName())
                            .description(category.getDescription())
                            .status(category.getStatus().getStatusValue())
                            .build();
                    recordsCategory.add(categoryRecord);
                });
        return recordsCategory;
    }
}
