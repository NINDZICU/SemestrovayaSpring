package ru.kpfu.converters;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;
import org.springframework.stereotype.Component;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.repositories.GoodJPARepository;
import ru.kpfu.repositories.UserJPARepository;

@Component
public class IntegerToEntityConverter implements GenericConverter {
    @Autowired
    GoodJPARepository goodJPARepository;
    @Autowired
    UserJPARepository userJPARepository;

    public IntegerToEntityConverter() {
    }

    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> types = new HashSet();
        types.add(new ConvertiblePair(Integer.class, GoodJPA.class));
        types.add(new ConvertiblePair(Integer.class, UserJPA.class));
        return types;
    }

    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if(Integer.class.equals(sourceType.getType())) {
            if((Integer)source == null) {
                return null;
            }

            Integer id = (Integer)source;
            if(GoodJPA.class.equals(targetType.getType())) {
                return this.goodJPARepository.findOne(id);
            }

            if(UserJPA.class.equals(targetType.getType())) {
                return this.userJPARepository.findOne(id);
            }
        }

        throw new IllegalArgumentException("Cannot convert " + source + " into a suitable type!");
    }
}