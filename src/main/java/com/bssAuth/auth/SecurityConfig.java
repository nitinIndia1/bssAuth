package com.bssAuth.auth;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.function.*;
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    
    
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*"); 
//        configuration.addAllowedMethod("*"); 
//        configuration.addAllowedHeader("*"); 
//        //configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new 
//         UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
    
    
    
    
    //from spring boot docs
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        //configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
//        configuration.addAllowedOrigin("*");
//        //configuration.setAllowedMethods(Arrays.asList("GET"));
//        configuration.addAllowedHeader("*");
//        configuration.setAllowedHeaders(List.of("Authorization"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//    
//    
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http.csrf(csrf->csrf.disable())
    	.cors().disable()
//    	.cors(Customizer.withDefaults())
//    	 .configurationSource(corsConfigurationSource())
//    	 .and()
    	.authorizeHttpRequests(
    			auth->auth.requestMatchers("/crbt/api/subscriber/ivr/**").authenticated()
    			.requestMatchers("/auth/login","/otp/**","/actuator/**").permitAll()
    			//.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
    			.anyRequest().authenticated()
    			).exceptionHandling(ex->ex.authenticationEntryPoint(point))
    	.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	
    	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
    	return http.build();
    	
    	
    	
    }


}
