/*
 * package com.laptop.laptopbag.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration;import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfiguration {
 * 
 * @Bean public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
 * return new CustomBasicAuthenticationEntryPoint(); }
 * 
 *//**
	 * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
	 * 
	 * @return
	 */
/*
 * @Bean public UserDetailsService users() { UserDetails admin =
 * User.builder().username("admin").password("{noop}welcome").roles("ADMIN").
 * build(); return new InMemoryUserDetailsManager(admin); }
 * 
 *//**
	 * 
	 * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 *//*
		 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
		 * Exception {
		 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
		 * STATELESS).and().csrf().disable()
		 * .authorizeRequests().requestMatchers("/laptop-bag/webapi/api/**",
		 * "/laptop-bag/webapi/delay/**")
		 * .permitAll().requestMatchers("/laptop-bag/webapi/secure/**").authenticated().
		 * and().httpBasic() .authenticationEntryPoint(getBasicAuthEntryPoint()); return
		 * http.build(); }
		 * 
		 * }
		 */