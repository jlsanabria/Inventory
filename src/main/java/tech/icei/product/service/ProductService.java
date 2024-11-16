package tech.icei.product.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import tech.icei.product.model.Category;

@Slf4j
@Named
@ApplicationScoped
public class ProductService {
    public boolean addCategory(Category category) {
      return true;
        //return categoryDAO.createCategory(category);
    }
}
