package top.aranlzh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 拓展springmvc

// @EnableWebMvc 如果这里使用这个注解，就会失效，因为
// @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
// public class WebMvcAutoConfiguration {}

// 然而：
// @Import(DelegatingWebMvcConfiguration.class)
// public @interface EnableWebMvc {
// }
// public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {}

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    // 写在MyMvcConfig不生效：
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/indexPage","index");
    }
}
