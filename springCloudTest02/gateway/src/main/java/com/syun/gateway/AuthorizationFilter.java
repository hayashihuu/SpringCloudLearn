package com.syun.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @program: springCloudTest02
 * @author: syun
 * @create: 2018-11-15 15:52
 */
@Component
@Slf4j
public class AuthorizationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        ServerHttpRequest request = exchange.getRequest();
//        if (predicate(exchange)) {
//            request = headerEnhanceFilter.doFilter(request);
//            String accessToken = extractHeaderToken(request);
//
//            customRemoteTokenServices.loadAuthentication(accessToken);
//            LOGGER.info("success auth token and permission!");
//        }

        return chain.filter(exchange);

    }

    //提出头部的token
//    protected String extractHeaderToken(ServerHttpRequest request) {
//
//        List<String> headers = request.getHeaders().get("Authorization");
//        if (Objects.nonNull(headers) && headers.size() > 0) { // typically there is only one (most servers enforce that)
//            String value = headers.get(0);
//            if ((value.toLowerCase().startsWith(OAuth2AccessToken.BEARER_TYPE.toLowerCase()))) {
//                String authHeaderValue = value.substring(OAuth2AccessToken.BEARER_TYPE.length()).trim();
//                // Add this here for the auth details later. Would be better to change the signature of this method.
//                int commaIndex = authHeaderValue.indexOf(',');
//                if (commaIndex > 0) {
//                    authHeaderValue = authHeaderValue.substring(0, commaIndex);
//                }
//                return authHeaderValue;
//            }
//        }
//
//        return null;
//    }


    @Override
    public int getOrder() {
        return 0;
    }



}
