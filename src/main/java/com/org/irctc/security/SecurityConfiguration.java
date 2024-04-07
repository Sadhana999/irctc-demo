package com.org.irctc.security;

import com.org.irctc.service.impl.UserDetailsServiceImpl;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {

    @Autowired
    private BCryptConfiguration bCryptConfiguration;
    @Autowired
    private AuthenticationFilter authenticationFilter;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(username -> userDetailsService.loadUserByUsername(username))
                .passwordEncoder(bCryptConfiguration.passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/v1/authenticate/log-in")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/v1/user/register")).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt().decoder(token -> jwtDecoder(token)).jwtAuthenticationConverter(jwtAuthenticationConverter()).and()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(authenticationFilter , UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
        return http.build();
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("USER_PERMISSIONS");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("PERMISSION_");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }

    private Jwt jwtDecoder(Object token){
        try {
            JWT jwt = JWTParser.parse((String) token);
            Map<String, Object> headers = new LinkedHashMap<>(jwt.getHeader().toJSONObject());
            Map<String, Object> claims = jwt.getJWTClaimsSet().getClaims();
            return Jwt.withTokenValue((String) token)
                    .headers(h -> h.putAll(headers))
                    .claims(c -> c.putAll(claims))
                    .expiresAt(((Date)jwt.getJWTClaimsSet().getClaim("exp")).toInstant())
                    .issuedAt(((Date)jwt.getJWTClaimsSet().getClaim("iat")).toInstant())
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
