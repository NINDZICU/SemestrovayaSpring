package ru.kpfu.converters;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.repositories.UserJPARepository;

@Component
public class IntegerToUserConverter implements Converter<Integer, UserJPA> {
    @Autowired
    UserJPARepository userJPARepository;

    public IntegerToUserConverter() {
    }

    public UserJPA convert(Integer id) {
        return (UserJPA)this.userJPARepository.findOne(id);
    }
}
