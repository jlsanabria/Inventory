package tech.icei.product.bean;


import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tech.icei.product.dto.CategoryDTO;
import tech.icei.product.dto.CategoryRecord;
import tech.icei.product.model.Category;
import tech.icei.product.service.CategoryService;
import tech.icei.product.service.ProductService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Named(value = "categoryBean")
@ViewScoped
public class CategoryBean implements Serializable {

    //private CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;
    private List<CategoryRecord> categoryList;
    private String searchCategory;

    public CategoryBean() {

    }

    @PostConstruct
    public void init() {
        categoryDTO = new CategoryDTO();
        categoryList = new ArrayList<>();
        searchCategory = "";
        loadCategoryRecordList();
    }


    public void categorySave() {
        log.info("Nombre categoría --> " + categoryDTO.getName());
        log.info("Descripcion --> " + categoryDTO.getDescription());

        //Category category = loadCategory();
        categoryService.addCategory(loadCategory());
        //productService.addCategory(loadCategory());
    }

    private Category loadCategory() {
        //Category category = new Category();
        //category.setName(categoryDTO.getName());
        //category.setDescription(categoryDTO.getDescription());
        return Category
                .builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .build();
    }

    private void loadCategoryRecordList() {
        categoryList = categoryService.listCategories(searchCategory);
    }

}
