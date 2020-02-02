package cn.weibin.springboot.configure;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Web Mvc配置
 * @author weibin
 */
// @Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    // @Override
    // protected void addInterceptors(InterceptorRegistry registry) {
    //     super.addInterceptors(registry);
    //     // String[] excludes = { "/static/**"};
    //     // LoginInterceptor authInterceptor = new LoginInterceptor();
    //     // registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns(excludes);
    // }

    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //     super.addResourceHandlers(registry);
    //     String[] a = {"/index.html", "/favicon.ico", "/js/**", "/css/**", "/fonts/**"};
    //     registry.addResourceHandler(a);
    // }
}