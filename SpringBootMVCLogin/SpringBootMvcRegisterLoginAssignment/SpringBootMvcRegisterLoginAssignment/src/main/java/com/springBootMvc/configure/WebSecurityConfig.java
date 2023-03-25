package com.springBootMvc.configure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.springBootMvc.model.User;
import com.springBootMvc.model.UserSession;
import com.springBootMvc.repository.UserRepository;
import com.springBootMvc.repository.UserSessionRepository;
import com.springBootMvc.service.CustomUserDetailService;
import com.springBootMvc.service.CustomUserDetails;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailService userDetailService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserSessionRepository userSessionRepository;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailService).passwordEncoder(bcryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/loginsuccess").authenticated().and().formLogin()
				.loginPage("/user/login").loginProcessingUrl("/login").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/user/loginsuccess").and().logout()
				.logoutSuccessHandler((LogoutSuccessHandler) new LogoutSuccessHandler() {

					@Override
					public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
							org.springframework.security.core.Authentication authentication)
							throws IOException, ServletException {
						CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
						String username = userDetails.getUsername();
						User user = userRepository.findByUsername(username);
						UserSession userSession = new UserSession();
						userSession.setEventType("LOGOUT");
						userSession.setUser(user);
						userSessionRepository.save(userSession);
						response.sendRedirect("/user/login?logout");
						
					}
				});
	}

}
