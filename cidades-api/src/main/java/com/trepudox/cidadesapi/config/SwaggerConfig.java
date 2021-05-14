package com.trepudox.cidadesapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.trepudox.cidadesapi.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("API Cidades")
                .description("API desenvolvida para realizar consultas a países ou cidades de todo o país")
                .version("1.0")
                .contact(new Contact("Marco Aurélio Queiroz", "https://github.com/trepudox",
                        "marcoa.queiroz1722@gmail.com")).build();
    }
}
