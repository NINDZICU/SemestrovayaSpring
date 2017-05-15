package ru.kpfu.converters;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.repositories.GoodJPARepository;

@Component
public class IntegerToGoodConverter implements Converter<Integer, GoodJPA> {
    @Autowired
    GoodJPARepository goodJPARepository;

    public IntegerToGoodConverter() {
    }

    public GoodJPA convert(Integer id) {
        return (GoodJPA)this.goodJPARepository.findOne(id);
    }
}