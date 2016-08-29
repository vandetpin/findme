package com.findme.bootstrap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"SELECT username, password, isActive as enabled FROM UserAccount WHERE username=?")
		.authoritiesByUsernameQuery(
			"SELECT username, role FROM UserRole WHERE username=?");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/visitor/signup**").permitAll()
        .antMatchers("/professionals/**").access("hasRole('ROLE_PROFESSIONAL')")
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        
        .antMatchers("/professionals/api/appointments").access("hasRole('ROLE_PROFESSIONAL')")
        .antMatchers("/professionals/api/visitors").access("hasRole('ROLE_PROFESSIONAL')")
        .antMatchers("/visitors/api/appointments").access("hasRole('ROLE_VISITOR')")
        
        
        .and().formLogin().loginPage("/login").failureUrl("/login?error")
        .usernameParameter("username").passwordParameter("password")
        .defaultSuccessUrl("/home")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}