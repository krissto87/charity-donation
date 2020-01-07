package krissto87.charity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    public SecurityConfig(DataSource dataSource, AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.dataSource = dataSource;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT email, password, active FROM users WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, r.name FROM users u JOIN users_roles ur ON u.id = ur.user_id JOIN roles r ON ur.roles_id = r.id WHERE u.email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").authenticated()
                .antMatchers("/user", "/user/**").hasRole("USER")
                .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }
}
