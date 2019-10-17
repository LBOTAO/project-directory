package com.happy.smp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //让spring来加载该类配置
@EnableSwagger2 //启用Swagger2
public class Swagger2Config {

    /**
     * 接口文档ui访问地址：
     * http://localhost:8080/swagger-ui.html
     */

    /**
     * 创建API应用
     * createApiInfo() 增加api相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，用来控制哪些接口暴露给Swagger来展现
     * 采用指定扫描的包路径来定义指定要建立API的目录
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .select()
                //暴露给Swagger的包路径
                .apis(RequestHandlerSelectors.basePackage("com.happy.smp.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息
     * 访问地址：http://localhost:8080/swagger-demo/swagger-ui.html
     * @return
     */
    protected ApiInfo createApiInfo(){
        return new ApiInfoBuilder()
                //标题
                .title("SpringBoot整合MybatisPlus，很牛X")
                //标题下方的小字
                .description("详情请关注https://swagger.io/resources/open-api/")
                //组织服务地址
                .termsOfServiceUrl("https://swagger.io/resources/open-api/")
                //开发者
                .contact("happy")
                //API版本
                .version("0.1")
                .build();
    }
}
