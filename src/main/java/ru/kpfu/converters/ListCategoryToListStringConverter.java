package ru.kpfu.converters;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.CategoryJPA;

@Component
public class ListCategoryToListStringConverter implements Converter<List<CategoryJPA>, List<String>> {
    public ListCategoryToListStringConverter() {
    }

    public List<String> convert(List<CategoryJPA> source) {
        List<String> namesCategories = new ArrayList();
        Iterator var3 = source.iterator();

        while(var3.hasNext()) {
            CategoryJPA k = (CategoryJPA)var3.next();
            namesCategories.add(k.getName());
        }

        return namesCategories;
    }
}