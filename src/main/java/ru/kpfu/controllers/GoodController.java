package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.entities.CommentJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.repositories.GoodJPARepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Anatoly on 28.05.2017.
 */
@Controller
@RequestMapping("/good/{id}")
//@SessionAttributes(value = "good_id")
@PreAuthorize("isAuthenticated()")
public class GoodController {
    @Autowired
    private GoodJPARepository goodJPARepository;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("")
    public String showGood(@PathVariable Integer id, Map map) {
        GoodJPA good = goodJPARepository.findOne(Integer.valueOf(id));
        List goods = new ArrayList();
        goods.add(good);
        map.put("goods", goods);
        map.put("comment", new CommentJPA());


        return "goodInfo";
    }

    @RequestMapping(value = "/add")
    @PreAuthorize("isAuthenticated()")
    public String addGoodToBucket(@PathVariable Integer id, HttpSession httpSession) {
        List<GoodJPA> goods = new ArrayList<>();
        if (httpSession.getAttribute("bucket") != null) {
            goods = (List<GoodJPA>) httpSession.getAttribute("bucket");
        }
        goods.add(goodJPARepository.findOne(id));
        httpSession.setAttribute("bucket", goods);
//        modelAndView.addObject("good_id", ids);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#showBucket").build();
    }



}
