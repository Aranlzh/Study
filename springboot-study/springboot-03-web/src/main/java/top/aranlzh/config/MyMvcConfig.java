package top.aranlzh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// 如果想要一些定制化的功能，只要写这个组件，然后把它交给springboot，springboot就会帮我们自动装配
// 扩展springmvc dispatchservlet
// @EnableWebMvc 导入了一个类 DelegatingWebMvcConfiguration（委派 Web Wvc 配置）：从容器中获取所有的webmvcconfig

// @Autowired(required = false)
// public void setConfigurers(List<WebMvcConfigurer> configurers) {
//     if (!CollectionUtils.isEmpty(configurers)) {
//         this.configurers.addWebMvcConfigurers(configurers);
//     }
// }


@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

    // // ViewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器
    // @Bean
    // public ViewResolver myViewResolver() {
    //     return new MyViewResolver();
    // }
    //
    // // 自定义了一个自己的视图解析器MyViewResolver
    // public static class MyViewResolver implements ViewResolver {
    //
    //     @Override
    //     public View resolveViewName(String s, Locale locale) throws Exception {
    //         return null;
    //     }
    // }

    // 跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("POST","GET");
    }
}
