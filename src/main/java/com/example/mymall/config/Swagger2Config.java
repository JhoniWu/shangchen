package com.example.mymall.config;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.*;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: MyMall
 * @description: Swagger2API文档配置文件
 * @author: Max Wu
 * @create: 2023-03-10 17:47
 **/
@Configuration
@EnableSwagger2
@EnableWebMvc
public class Swagger2Config implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/**").addResourceLocations(
			"classpath:/static/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
			"classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations(
			"classpath:/META-INF/resources/webjars/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	@Bean
    public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.select()
                //为当前包下controller生成API文档
			.apis(RequestHandlerSelectors.basePackage("com.example.mymall.controller"))
                //为有@Api注解的Controller生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
			.paths(PathSelectors.any())
			.build()
                //添加登录认证
			.securitySchemes(securitySchemes())
			.securityContexts(securityContexts());
	}

	private List<SecurityContext> securityContexts() {
		//设置需要登录认证的路径
		List<SecurityContext> result = new ArrayList<>();
		result.add(getContextByPath("/brand/.*"));
		return result;
	}

	private SecurityContext getContextByPath(String pathRegex) {
		return SecurityContext.builder()
			.securityReferences(defaultAuth())
			.forPaths(PathSelectors.regex(pathRegex))
			.build();
	}

	private List<SecurityReference> defaultAuth() {
		List<SecurityReference> result = new ArrayList<>();
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		result.add(new SecurityReference("Authorization", authorizationScopes));
		return result;
	}

	private List<ApiKey> securitySchemes() {
		//设置请求头的信息
		List<ApiKey> result = new ArrayList<>();
		ApiKey apiKey = new ApiKey("Authorization" , "Authorization", "header");
		result.add(apiKey);
		return result;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("SwaggerUI演示")
			.description("mall-tiny")
			.contact("example")
			.version("1.0")
			.build();
	}
	@Bean
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(WebEndpointsSupplier webEndpointsSupplier,
																		 ServletEndpointsSupplier servletEndpointsSupplier, ControllerEndpointsSupplier controllerEndpointsSupplier,
																		 EndpointMediaTypes endpointMediaTypes, CorsEndpointProperties corsProperties,
																		 WebEndpointProperties webEndpointProperties, Environment environment) {
		List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
		Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
		allEndpoints.addAll(webEndpoints);
		allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
		allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
		String basePath = webEndpointProperties.getBasePath();
		EndpointMapping endpointMapping = new EndpointMapping(basePath);
		boolean shouldRegisterLinksMapping =
			webEndpointProperties.getDiscovery().isEnabled() && (StringUtils.hasText(basePath)
				|| ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT));
		return new WebMvcEndpointHandlerMapping(endpointMapping, webEndpoints, endpointMediaTypes,
			corsProperties.toCorsConfiguration(), new EndpointLinksResolver(allEndpoints, basePath),
			shouldRegisterLinksMapping, null);
	}
}
