package tech.icei.product.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tech.icei.product.dto.CategoryDTO;
import tech.icei.product.model.Category;
import tech.icei.util.HibernateUtil;

import java.util.List;
import java.util.Objects;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    @Transactional
    public boolean createCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        session.persist(category);
        transaction.commit();
        return Objects.nonNull(category);
    }

    @Override
    public List<Category> readCategories(String criteria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        List<Category> categories = (List<Category>) session
                .createQuery("FROM Category c WHERE (c.name LIKE :criteria OR c.description LIKE :criteria) ", Category.class)
                .setParameter("criteria", "%" + criteria + "%")
                .list();
        return categories;
    }

    @Override
    public Category updateCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        Category categoryUpdated = (Category) session.find(Category.class, category.getCategoryId());
        if(Objects.nonNull(categoryUpdated)) {
            categoryUpdated.setName(category.getName());
            categoryUpdated.setDescription(category.getDescription());
            categoryUpdated = session.merge(categoryUpdated);
        }
        return categoryUpdated;
    }

    @Override
    public boolean deleteCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        Category categoryDeleted = (Category) session.find(Category.class, category.getCategoryId());
        if(Objects.nonNull(categoryDeleted)) {
            session.remove(categoryDeleted);
            return true;
        }
        return false;
    }

    @Override
    public void addCategory(Category category) {
        // JDBC --> Java Database Connectivity
//        Connection con = null;
//        Statement stmt = con.createStatement();
//        stmt.executeQuery("INSERT INTO nombre_tabla VALUES ("+category.getName()+", )")
//        PreparedStatement ps = con.prepareStatement("INSERT INTO ");
    }
}
