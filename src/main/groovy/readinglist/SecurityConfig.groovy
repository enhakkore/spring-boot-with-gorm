package readinglist

import org.springframework.context.annotation.Configuration

import org.springframework.security.config.annotaion.authenticatiion.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotaion.web.builders.HttpSecurity
import org.springframework.secutity.config.annotaion.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotaion.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdatails.UserDetailsService

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/**").permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
    }

    void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(
                { username -> Reader.findByUsername(username)}
                as UserDetailsService)
    }
}
