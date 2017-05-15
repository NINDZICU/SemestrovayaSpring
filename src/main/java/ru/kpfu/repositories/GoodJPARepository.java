package ru.kpfu.repositories;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;

@Repository
public interface GoodJPARepository extends JpaRepository<GoodJPA, Integer> {
    List<GoodJPA> findGoodsJPASByCategories(CategoryJPA var1);
}
