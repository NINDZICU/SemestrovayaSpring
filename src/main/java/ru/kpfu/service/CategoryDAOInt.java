package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;

@Service
public interface CategoryDAOInt {
    List<CategoryJPA> findAllCategory();

    CategoryJPA findCategoryByName(String var1);

    List<CategoryJPA> findCategoryByGood(GoodJPA var1);

    void addCategory(CategoryJPA var1);

    void deleteCategory(int var1);
}
