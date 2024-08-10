package com.proyecto.reposteria.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> {
                    //authorize.requestMatchers(toH2Console()).permitAll();
                    authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/usuario/**")).permitAll();
                    authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/login/**")).permitAll();
                    authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/public/**")).permitAll();
                    // TODO: Revisar como manejar la autenticacion para admin
                    authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/admin/**")).permitAll();
                    authorize.requestMatchers(AntPathRequestMatcher.antMatcher("/api/producto/**")).authenticated();
                    authorize.anyRequest().authenticated()
                            .and().authenticationProvider(authenticationProvider);

                }).httpBasic(withDefaults());
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers(toH2Console()).disable());
        http.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.disable());
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
