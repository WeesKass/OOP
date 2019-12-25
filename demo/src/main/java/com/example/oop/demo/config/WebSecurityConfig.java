//package com.example.oop.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/issue/confirmation/*", "/issue/undo/*").permitAll()
//                .antMatchers("/admin/***", "/author/***", "/book/***", "/category/***", "/subCategory/***", "/issue/***", "/publisher/***", "/student/***").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("password")
//                        .roles("ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//}
//
//
////@Configuration
////@EnableWebSecurity
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////    @Autowired
////    private DataSource dataSource;
////
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .passwordEncoder(NoOpPasswordEncoder.getInstance())
////                .usersByUsernameQuery("select username, password, active from user where username=?")
////                .authoritiesByUsernameQuery("select u.username, ur.roles from `user` u inner join user_role ur on u.user_id where username=?");
////
////
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http.authorizeRequests()
////                    .antMatchers("/register", "/", "/static/**", "/issue/confirmation/*", "/issue/undo/*").permitAll()
////                    .anyRequest().authenticated()
////                .and()
////                    .formLogin()
////                    .loginPage("/login")
////                    .permitAll()
////                .and()
////                    .logout()
////                    .permitAll();
////    }
////
////}
