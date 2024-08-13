// package com.jyoticodes.springbootdemo.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SpringSecurity {

//     @SuppressWarnings("removal")
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(authorizeRequests ->
//                 authorizeRequests
//                     .requestMatchers("/Journal/**").hasRole("ADMIN")
//                     .requestMatchers("/User/**").hasRole("ADMIN")
//                     .anyRequest().authenticated()).httpBasic();
//                     http
//                     .csrf().disable()  // Disable CSRF for testing
//                     .httpBasic();
                
            
//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails user = User.withDefaultPasswordEncoder()
//             .username("user")
//             .password("password")
//             .roles("USER")
//             .build();

//         UserDetails admin = User.withDefaultPasswordEncoder()
//             .username("admin")
//             .password("admin")
//             .roles("ADMIN")
//             .build();

//         return new InMemoryUserDetailsManager(user, admin);
//     }
// }
