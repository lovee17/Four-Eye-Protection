package com.brd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DataSource getDataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.1.50.198:1535:nsbt19c");
        dataSource.setUsername("training");
        dataSource.setPassword("training");
        return dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        DataSource ds = (DataSource) getDataSource();
        auth.jdbcAuthentication().dataSource(ds)
                .passwordEncoder(passwordEncoder());
    }




    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                // Spring Security should completely ignore URLs ending with .html
                .antMatchers("/*.html")

        ;
    }

//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//        http
//                .authorizeRequests()
//                .antMatchers("/makerHome/**","/").access("hasRole('Maker')")
////                .antMatchers("/checkerHome/**","makerHome/linkview").access("hasRole('Checker')")
//                .and()
//                .formLogin()
//                .and()
//                .logout()
//                .logoutUrl("/j_spring_security_logout")
//                .logoutSuccessUrl("/")   ;
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/makerHome/maker","/checkerHome/checker")
                .authenticated()
                .antMatchers("/makerHome/maker").hasRole("MAKER")
                .antMatchers("/checkerHome/checker").hasRole("CHECKER")
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf()
                .disable();
    }

}
