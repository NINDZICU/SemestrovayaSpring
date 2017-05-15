package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.repositories.GoodJPARepository;

@Service
public class GoodDAO implements GoodDAOInt {
    @Autowired
    GoodJPARepository goodJPARepository;

    public GoodDAO() {
    }

    public List<GoodJPA> findAllGoods() {
        return this.goodJPARepository.findAll();
    }

    public List<GoodJPA> findGoodsByCategory(CategoryJPA category) {
        return this.goodJPARepository.findGoodsJPASByCategories(category);
    }

    public void addGood(GoodJPA good) {
        this.goodJPARepository.save(good);
    }

    public void deleteGood(int id) {
        this.goodJPARepository.delete(Integer.valueOf(id));
    }
}

