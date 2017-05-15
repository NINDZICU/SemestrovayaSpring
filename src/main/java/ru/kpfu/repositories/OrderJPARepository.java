package ru.kpfu.repositories;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.entities.OrderJPA;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderJPA, Integer> {
}

