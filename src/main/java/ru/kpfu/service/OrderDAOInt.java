package ru.kpfu.service;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import org.springframework.stereotype.Service;
import ru.kpfu.entities.OrderJPA;

@Service
public interface OrderDAOInt {
    List<OrderJPA> findAllOrder();

    void addOrder(String var1);

    void deleteOrder(int var1);
}
