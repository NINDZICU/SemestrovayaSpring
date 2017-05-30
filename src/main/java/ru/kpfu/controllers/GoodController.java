package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.repositories.GoodJPARepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Anatoly on 28.05.2017.
 */
@Controller
@RequestMapping("/good/{id}")
public class GoodController {
    @Autowired
    private GoodJPARepository goodJPARepository;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("")
    public String showGood(@PathVariable Integer id, Map map){
        GoodJPA good = goodJPARepository.findOne(Integer.valueOf(id));
        List goods = new ArrayList();
        goods.add(good);
        map.put("goods",goods );
        map.put("comment", new CommentJPA());

        return "goodInfo";
    }
}
