package com.example.weTraveller.security;


import com.example.weTraveller.security.auth.internal.provider.AppAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppAuthProvider appAuthProvider;

    @Autowired
    public WebSecurityConfig(AppAuthProvider appAuthProvider) {
        this.appAuthProvider = appAuthProvider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.requiresChannel().anyRequest().requiresSecure();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/login",
                        "/register",
                        "/verify",
                        "/forgot-password",
                        "/reset-password",
                        "/sso",
                        "/backdoor",
                        "/css/**",
                        //"/api/v1/risk/**",
                        "/bundle.css",
                        "/js/**",
                        "/src/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/sso-logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(appAuthProvider);
    }
}
