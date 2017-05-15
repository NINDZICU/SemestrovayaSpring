package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;

@Service
public interface GoodDAOInt {
    List<GoodJPA> findAllGoods();

    List<GoodJPA> findGoodsByCategory(CategoryJPA var1);

    void addGood(GoodJPA var1);

    void deleteGood(int var1);
}
