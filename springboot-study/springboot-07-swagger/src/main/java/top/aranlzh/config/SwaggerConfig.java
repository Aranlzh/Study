package top.aranlzh.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.aranlzh.pojo.User;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@ConditionalOnProperty(prefix = "swagger", name = "open", havingValue = "true", matchIfMissing = false)
@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).ignoredParameterTypes(User.class)
                .groupName("index")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("top.aranlzh.controller"))
                .paths(PathSelectors.any())
                .build().securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标题")
                .description("所有需要登录的接口都需要传 (token) header.set()")
                .termsOfServiceUrl("http://127.0.0.1/")
                .version("1.0.0")
                .build();
    }

    private List<ApiKey> security() {

        return newArrayList(
               /* new ApiKey("token", "token", "header"),
                new ApiKey("token", "token", "header")*/
        );
    }
}
