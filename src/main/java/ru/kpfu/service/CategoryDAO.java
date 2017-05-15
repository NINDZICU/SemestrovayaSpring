package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.repositories.CategoryJPARepository;

@Service
public class CategoryDAO implements CategoryDAOInt {
    @Autowired
    CategoryJPARepository categoryJPARepository;

    public CategoryDAO() {
    }

    public List<CategoryJPA> findAllCategory() {
        return this.categoryJPARepository.findAll();
    }

    public CategoryJPA findCategoryByName(String name) {
        return this.categoryJPARepository.findCategoryJPAByName(name);
    }

    public List<CategoryJPA> findCategoryByGood(GoodJPA good) {
        return this.categoryJPARepository.findCategoryJPASByGoods(good);
    }

    public void addCategory(CategoryJPA category) {
        this.categoryJPARepository.save(category);
    }

    public void deleteCategory(int id) {
        this.categoryJPARepository.delete(Integer.valueOf(id));
    }
}
