package ru.kpfu.converters;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.service.CategoryDAOInt;

@Component
public class StringToCategoryConverter implements Converter<String, CategoryJPA> {
    @Autowired
    CategoryDAOInt categoryDAO;

    public StringToCategoryConverter() {
    }

    public CategoryJPA convert(String name) {
        return this.categoryDAO.findCategoryByName(name);
    }
}
