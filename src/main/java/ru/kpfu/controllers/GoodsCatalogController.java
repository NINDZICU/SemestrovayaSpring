package ru.kpfu.controllers;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.annotations.MyAnnotation;
import ru.kpfu.converters.IntegerToGoodConverter;
import ru.kpfu.converters.ListCategoryToListStringConverter;
import ru.kpfu.converters.StringToCategoryConverter;
import ru.kpfu.entities.CategoryJPA;
import ru.kpfu.entities.GoodJPA;
import ru.kpfu.service.CategoryDAOInt;
import ru.kpfu.service.GoodDAOInt;

import javax.validation.Valid;

@Controller
@RequestMapping({"/catalog"})
@PreAuthorize("isAuthenticated()")
public class GoodsCatalogController {
    @Autowired
    private CategoryDAOInt categoryDAO;
    @Autowired
    private GoodDAOInt goodDAO;
    @Autowired
    private ListCategoryToListStringConverter listCategoryToListString;
    @Autowired
    private StringToCategoryConverter stringToCategoryConverter;
    @Autowired
    private IntegerToGoodConverter integerToGoodConverter;

    public GoodsCatalogController() {
    }

    @MyAnnotation
    @RequestMapping({""})
    @PreAuthorize("isAuthenticated()")
    public String showGoods(Map map) {
        List<GoodJPA> goods = this.goodDAO.findAllGoods();
        map.put("goods", goods);
        map.put("catalog_goods", goods);
        return "goods";
    }

    @MyAnnotation
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = {"/add"},
            method = {RequestMethod.GET}
    )
    public String getAddGood(Map map) {
        map.put("good", new GoodJPA());
        List<CategoryJPA> categories = this.categoryDAO.findAllCategory();
        map.put("categories", this.listCategoryToListString.convert(categories));
        return "addGood";
    }

    @MyAnnotation
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = {"/add"},
            method = {RequestMethod.POST}
    )
    public String addGood(@Valid @ModelAttribute("good") GoodJPA good, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "addGood";
        } else {
            Set<CategoryJPA> categories = new HashSet();
            Iterator var5 = good.getCategories().iterator();

            while(var5.hasNext()) {
                CategoryJPA k = (CategoryJPA)var5.next();
                categories.add(this.stringToCategoryConverter.convert(k.getName()));
            }

            good.setCategories(categories);
            this.goodDAO.addGood(good);
            redirectAttributes.addFlashAttribute("message", "Add Success");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GCC#getAddGood").build();
        }
    }
    @MyAnnotation
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping({"/drop/{id}"})
    public String dropGood(@PathVariable Integer id) {
        this.goodDAO.deleteGood(id.intValue());
        return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GCC#showGoods").build();
    }

    @RequestMapping(
            value = {"/edit/{id}"},
            method = {RequestMethod.GET}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditGood(@PathVariable Integer id, Map map) {
        map.put("good", this.integerToGoodConverter.convert(id));
        return "editGood";
    }

    @RequestMapping(
            value = {"/edit/{id}"},
            method = {RequestMethod.POST}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public String editGood(@PathVariable Integer id,@Valid @ModelAttribute("good") GoodJPA good, BindingResult result) {
        if(result.hasErrors()){
            return "editGoods";
        }
        else {
            Set<CategoryJPA> categories = new HashSet();
            Iterator var4 = good.getCategories().iterator();

            while (var4.hasNext()) {
                CategoryJPA k = (CategoryJPA) var4.next();
                categories.add(this.stringToCategoryConverter.convert(k.getName()));
            }
            good.setCategories(categories);
            good.setId(id);

            this.goodDAO.addGood(good);

            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("GCC#showGoods").build();
        }
    }

    @RequestMapping("/{category}")
    public String showGoodByCategory(@PathVariable String category, Map map){
        List<GoodJPA> goods = this.goodDAO.findGoodsByCategory(categoryDAO.findCategoryByName(category));
        map.put("goods", goods);
        map.put("catalog_goods", goods);
        return "goods";
    }
}
