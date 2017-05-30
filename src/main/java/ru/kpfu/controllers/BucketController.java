package ru.kpfu.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.entities.GoodJPA;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;

/**
 * Created by Anatoly on 30.05.2017.
 */
@Controller
@RequestMapping("/bucket")
@PreAuthorize("isAuthenticated()")
public class BucketController {

    @RequestMapping("")
    public String showBucket(HttpSession httpSession, Map map) {
        map.put("goods", httpSession.getAttribute("bucket"));
        return "bucket";
    }

    @RequestMapping(value = "/remove/{id}")
    public String dropGoodFromBucket(@PathVariable Integer id, HttpSession httpSession) {
        List<GoodJPA> goods = new ArrayList<>();
        if (httpSession.getAttribute("bucket") != null) {
            goods = (List<GoodJPA>) httpSession.getAttribute("good_id");
        }
        for (GoodJPA good : goods) {
            if (good.getId().equals(id)) {
                goods.remove(good);
                break;
            }
        }
        httpSession.setAttribute("bucket", goods);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#showBucket").build();
    }

    @RequestMapping(value = "/remove/all", method = RequestMethod.GET)
    public String dropAllGoodFromBucket(HttpSession httpSession){
        httpSession.setAttribute("bucket", null);
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#showBucket").build();
    }
}
