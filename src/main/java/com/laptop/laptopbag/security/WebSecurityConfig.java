package com.laptop.laptopbag.security;

/*
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy;
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
 * STATELESS).and().csrf().disable()
 * .authorizeRequests().antMatchers("/laptop-bag/webapi/api/**",
 * "/laptop-bag/webapi/delay/**").permitAll()
 * .antMatchers("/laptop-bag/webapi/secure/**").authenticated().and().httpBasic(
 * ).authenticationEntryPoint(getBasicAuthEntryPoint()); }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.inMemoryAuthentication().withUser("admin").password("{noop}welcome").
 * roles("ADMIN"); }
 * 
 * @Bean public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
 * return new CustomBasicAuthenticationEntryPoint(); }
 * 
 * }
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/laptop-bag/webapi/api/**", "/laptop-bag/webapi/delay/**").permitAll()
                .requestMatchers("/laptop-bag/webapi/secure/**").authenticated()
            )
            .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(getBasicAuthEntryPoint()));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("{noop}welcome")
            .roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public BasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }
}

