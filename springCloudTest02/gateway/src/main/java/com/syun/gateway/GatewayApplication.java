package com.syun.gateway;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class GatewayApplication {


    private final static String FORWARDED_URL = "X-CF-Forwarded-Url";

    private final static String PROXY_METADATA = "X-CF-Proxy-Metadata";

    private final static String PROXY_SINGATURE = "X-CF-Proxy-Signature";


    @Autowired
    private SimpleLoggingFilter simpleLoggingFilter;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        String httpUri = "http://httpbin.org:80";
//        StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
//        config.setParts(1);
        return builder.routes()
                .route("path_route", p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route("retry_java", r -> r.path("/test/**")
                        .filters(f -> f.stripPrefix(1)
                                .retry(config -> config.setRetries(2).setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                                .filter(simpleLoggingFilter))
                        .uri("lb://service-feign"))
                .build();
//        return builder.routes()
//                .route(r -> r.header(FORWARDED_URL, ".*")
//                        .and()
//                        .header(PROXY_METADATA, ".*")
//                        .and()
//                        .header(PROXY_SINGATURE, ".*")
//                        .uri("http://google.com:80"))
//                .build();
    }

    @RequestMapping("/fallback")
    public Map<String, String> fallback() {
        Map<String, String> res = new HashMap();
        res.put("code", "-100");
        res.put("data", "service not available");
        return res;
    }




}
