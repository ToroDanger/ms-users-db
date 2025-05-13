package cl.duoc.ms_users_db.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,JwtAuthFilter jwtAuthFilter) throws Exception {
       return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/v1/admin").hasRole("ADMIN")
                .requestMatchers("/v1/**").authenticated()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class )
            .build();
    }
}

