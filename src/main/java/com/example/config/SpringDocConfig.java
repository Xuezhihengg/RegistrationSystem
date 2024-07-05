package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(this.getInfo());
    }

    private Info getInfo(){
        return new Info()
                .title("研究生监考报名系统")
                .version("1.0.0")
                .description("西安交通大学--2024夏季小学期--软件学院")
                .termsOfService("https://example.com");
    }
}