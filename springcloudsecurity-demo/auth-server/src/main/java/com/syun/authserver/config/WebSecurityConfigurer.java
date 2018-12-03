package com.syun.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @description:
 * @program: springcloudsecurity-demo
 * @author: syun
 * @create: 2018-11-24 16:47
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                .and().csrf()
                .and().formLogin().loginPage("/login");
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("user")
                .roles("USER")
                .and()
                .withUser("admin").password("admin")
                .roles("USER", "ADMIN");
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {

                return (String) charSequence;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                charSequence.toString().equals(s);
                return charSequence.toString().equals(s);
            }
        };
    }

    @Override
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsServiceBean()
            throws Exception {
        return super.userDetailsServiceBean();
    }
}
