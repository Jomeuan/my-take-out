package com.example.mytakeout.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.mytakeout.entity.Authority;
import com.example.mytakeout.security.MyAuthenticationFailureHandler;
import com.example.mytakeout.security.MyUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize) -> authorize
                                .requestMatchers("/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/category","/dish").hasAnyAuthority(Authority.ROLE_ADMIN,Authority.ROLE_STORE)
                                .requestMatchers(HttpMethod.PUT, "/category","/dish").hasAnyAuthority(Authority.ROLE_ADMIN,Authority.ROLE_STORE)
                                .requestMatchers(HttpMethod.DELETE, "/category","/dish").hasAnyAuthority(Authority.ROLE_ADMIN,Authority.ROLE_STORE)
                                .anyRequest().permitAll())
                .cors((cors) -> {
                    cors.configurationSource(corsConfigurationSource());
                })
                .formLogin(
                        (form) -> form.failureUrl("/login/error")
                                .failureHandler(new MyAuthenticationFailureHandler("/login/error", true)));
        http.csrf((csrf) -> csrf.disable());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://example.com", "http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
