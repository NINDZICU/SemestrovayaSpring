package ru.kpfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.models.forms.LoginForm;
import ru.kpfu.repositories.UserJPARepository;
import ru.kpfu.service.UserService;

import java.util.Map;

/**
 * Created by Anatoly on 21.05.2017.
 */
@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @PreAuthorize("isAnonymous()")
    public String login(@RequestParam(required = false) String error,@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, ModelMap map){
        map.put("error", error);
        return "security/authForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public String getRegistration(Map map){
        map.put("user", new UserJPA());
        return "security/regForm";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public String addUser(@ModelAttribute("user") UserJPA user, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "security/regForm";
        }
        else{
            System.out.println(user.getGender());
            userService.registerUser(user);
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GCC#showGoods").build();
        }
    }

}
