package ru.kpfu.controllers;

/**
 * Created by Anatoly on 15.05.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.converters.IntegerToEntityConverter;
import ru.kpfu.converters.IntegerToGoodConverter;
import ru.kpfu.converters.IntegerToUserConverter;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.service.CommentDAOInt;

@Controller
@RequestMapping({"/good/{id_good}/comment"})
public class CommentController {
    @Autowired
    private CommentDAOInt commentDAO;
    @Autowired
    private IntegerToGoodConverter integerToGoodConverter;
    @Autowired
    private IntegerToUserConverter integerToUserConverter;
    @Autowired
    private IntegerToEntityConverter integerToEntityConverter;

    public CommentController() {
    }

    @RequestMapping(
            value = {"/add"},
            method = {RequestMethod.POST}
    )
    public String addComment(@PathVariable Integer id_good, @ModelAttribute("comment") CommentJPA comment) throws NoSuchFieldException {
        System.out.println("COOMMMMMEMEMENTNTHSJGSGH"+comment+"IDIDIDID"+id_good);
        TypeDescriptor sourceType = TypeDescriptor.valueOf(Integer.class);
        TypeDescriptor targetType = TypeDescriptor.valueOf(GoodJPA.class);
        GoodJPA good = (GoodJPA)this.integerToEntityConverter.convert(id_good, sourceType, targetType);
        comment.setGood(good);
        targetType = TypeDescriptor.valueOf(UserJPA.class);
        //TODO сделать запись id юзера в сессию
        UserJPA user = (UserJPA)this.integerToEntityConverter.convert(Integer.valueOf(11), sourceType, targetType);
        comment.setUser(user);
        this.commentDAO.addComment(comment);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GC#showGood").arg(0, id_good).build();
    }
}