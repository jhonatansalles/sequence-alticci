package com.winprovit.alticci.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashMap;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()).build()
                .apiInfo(this.apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Projeto Backend Sequência Alticci")
                .description("Use a documentação como referência para consumir a API")
                .version("0.0.1")
                .contact(new Contact("Jhonatan Salles",
                        "https://github.com/jhonatansalles",
                        "jhonatanigor03@gmail.com"))
                .build();
    }

    @Controller
    public class SwaggerController {
        @GetMapping("/")
        public ModelAndView index() {
            return new ModelAndView("redirect:/swagger-ui/index.html", new HashMap<>());
        }
    }
}