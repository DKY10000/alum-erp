package com.dky.eureka.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*

/**
 * <p>Title: Swagger配置类</p>
 * <p>Description: Swagger配置类</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: 广东正来</p>
 * <p>@author: LinJK</p>
 * <p>@version: 1.0.0</p>
 *//*
*/


@Profile({"default", "develop", "test"})
@Configuration
@EnableSwagger2
class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder builder = new ParameterBuilder();

        Parameter parameter = builder
                .parameterType("header") //参数类型支持header, cookie, body, query etc
                .name("Authorization") //参数名
                .description("请输入您的Access Token")
                .modelRef(new ModelRef("string"))//指定参数值的类型
                .defaultValue("bearer {{access_token}}")
                .required(false)
                .build();

        Parameter systemIdParameter = builder
                .parameterType("header") //参数类型支持header, cookie, body, query etc
//                .name(ConstantCode.Sys_ID) //参数名
                .description("子系统ID - 10000000220101")
                .modelRef(new ModelRef("string"))//指定参数值的类型
                .required(true)
                .defaultValue("{{system_id}}")
                .build();

        List<Parameter> parameters = Lists.newArrayList(systemIdParameter, parameter);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("dky-eureka-service")
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dky.eureka.controller"))
                .paths(PathSelectors.any())
                .build()

                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("[RESTful APIs]--dky-eureka-service")
                .description("dky-eureka-service模块接口" + "--" + "[" + lastestBootInfo + "]")
                .contact("DKY")
                .version("1.0")
                .build();
    }

    private final static String lastestBootInfo;

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        lastestBootInfo = "最后启动时间: " + dateFormat.format(new Date());
    }
}

