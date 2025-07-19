package com.jarvisworkshop.StudyWithJarvis.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecuity) throws Exception{
        httpSecuity

                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(
                        request->request.anyRequest().authenticated()

                )
                .httpBasic(Customizer.withDefaults());


        return httpSecuity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        //{noop} no op password encoder
        UserDetails chandra = User.withUsername("chandra")
                .password("{noop}chandra123")
                .roles("ADMIN")
                .build();

        UserDetails gauri = User.withUsername("gauri")
                .password("{noop}gauri123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(chandra,gauri);
    }
}
