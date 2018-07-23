package com.xamthien.config.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


 
@Configuration
@EnableWebSecurity
public class WebSecurityCfg extends WebSecurityConfigurerAdapter {
//	@Autowired
//	UserDetailsServiceImpl userDetailsService;
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
 
//        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//        // Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
// 
//        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
// 
//        // Ngoại lệ AccessDeniedException sẽ ném ra.
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
// 
//        // Cấu hình cho Login Form.
//        http.authorizeRequests().and().formLogin()//
//                .loginProcessingUrl("/j_spring_security_check") // Servlet cua spring
//                .loginPage("/login")//
//                .defaultSuccessUrl("/userInfo")//
//                .failureUrl("/login?error=true")//
//                .usernameParameter("username")//
//                .passwordParameter("password")// chua biet de lam gi
//                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
        //==========================================================================
//        http.csrf().ignoringAntMatchers("/rest/**");
//        http.authorizeRequests().antMatchers("/rest/login**").permitAll();
//        http.antMatcher("/rest/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/rest/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
//            .antMatchers(HttpMethod.POST, "/rest/**").access("hasRole('ROLE_ADMIN')")
//            .antMatchers(HttpMethod.DELETE, "/rest/**").access("hasRole('ROLE_ADMIN')").and()
//            .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//            .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
}
