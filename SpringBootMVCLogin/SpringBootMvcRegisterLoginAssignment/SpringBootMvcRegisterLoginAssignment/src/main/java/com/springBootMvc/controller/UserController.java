package com.springBootMvc.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootMvc.model.User;
import com.springBootMvc.model.UserSession;
import com.springBootMvc.repository.UserRepository;
import com.springBootMvc.repository.UserSessionRepository;
import com.springBootMvc.service.CustomUserDetails;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSessionRepository userSessionRepository;
	
	@GetMapping("/")
	public String viewHomePage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistration()
	{
		
		return "registration";
	}
	
	@GetMapping("/login")
	public String viewLoginPage()
	{
		return "login";
	}
	
	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute User user) {
//		System.out.println(user);
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return "redirect:/user/login";

	}
	
	@GetMapping("/loginsuccess")
	public String loginSuccess(@AuthenticationPrincipal CustomUserDetails userDetails,Model model)
	{
		String username=userDetails.getUsername();
		User user=userRepository.findByUsername(username);
		model.addAttribute("user",user);
		UserSession userSession=new UserSession();
		userSession.setUser(user);
		userSession.setEventType("LOGIN");
		userSessionRepository.save(userSession);
		
		return "welcome_page";
	}
	
	@GetMapping("/logoutsuccess")
	public String logoutSuccess()
	{
		//String username=userDetails.getUsername();
//		User user=userRepository.findByUsername(username);
//		Optional<User> user=userRepository.findById(id);
//		UserSession userSession = new UserSession();
//		userSession.setEventType("LOGOUT");
//		userSession.setUser(user);
//		session.setAttribute("logoutmsg", "Log out successful!");
		 return "redirect:/user/login";
		
	}
}
