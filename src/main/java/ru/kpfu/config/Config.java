package ru.kpfu.config;

/**
 * Created by Anatoly on 15.05.2017.
 */
import java.util.List;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import ru.kpfu.loggers.WebServiceLogger;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({"ru.kpfu.controllers", "ru.kpfu.converters", "ru.kpfu.loggers","ru.kpfu.service", "ru.kpfu.captcha"})
public class Config extends WebMvcConfigurerAdapter {
    public Config() {
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("mainPage");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/css/**"}).addResourceLocations(new String[]{"/css/"});
        registry.addResourceHandler("/images1/**").addResourceLocations("file:E:\\Tolya\\Univer\\Прога 2курс\\kfu-programming-java4-master\\SemestrovayaSpring\\src\\main\\images\\");
        registry.addResourceHandler(new String[]{"/js/**"}).addResourceLocations(new String[]{"/js/"});
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");



    }


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(new String[]{"WEB-INF/locales/messages", "WEB-INF/locales/ValidationMessages"});
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(Integer.valueOf(4800));
        return resolver;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
    @Bean
    public WebServiceLogger webServiceLogger(){
        return new WebServiceLogger();
    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter(){
        ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
        return converter;
    }
    @Bean
    public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter(){
        AnnotationMethodHandlerAdapter adapter = new AnnotationMethodHandlerAdapter();
        adapter.setMessageConverters(new HttpMessageConverter[]{byteArrayHttpMessageConverter()});
        return adapter;
    }
}
