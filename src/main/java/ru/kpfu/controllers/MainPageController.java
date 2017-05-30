package ru.kpfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anatoly on 30.05.2017.
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @RequestMapping("")
    public String showMainPage(){
        return "mainPage";
    }
}
