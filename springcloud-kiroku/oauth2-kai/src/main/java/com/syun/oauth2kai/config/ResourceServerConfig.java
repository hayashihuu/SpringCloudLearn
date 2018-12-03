package com.syun.oauth2server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by wangyunfei on 2017/6/9.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//            .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//            .and()
//                .httpBasic();
    	
    	 http.
         anonymous().disable()
         .authorizeRequests()
         .antMatchers("/user/**").authenticated()
//         .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
         ;
    }
}
