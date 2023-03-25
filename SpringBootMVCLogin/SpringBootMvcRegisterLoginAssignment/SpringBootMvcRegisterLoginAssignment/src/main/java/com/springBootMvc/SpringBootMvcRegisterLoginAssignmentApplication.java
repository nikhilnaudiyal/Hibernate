package com.springBootMvc;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springBootMvc.model.User;
import com.springBootMvc.model.UserSession;
import com.springBootMvc.repository.UserRepository;
import com.springBootMvc.repository.UserSessionRepository;

@SpringBootApplication
public class SpringBootMvcRegisterLoginAssignmentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcRegisterLoginAssignmentApplication.class, args);
	}
	@Autowired
	UserSessionRepository userSessionRepository;
	
	@Autowired
	UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		
		
//		
//		
//		
//		
//		UserSession userSession=new UserSession("Login");
//		//userSession.setUser(user);
//		//System.out.println(userSession);
//		userSessionRepository.save(userSession);
//		
//		User user=new User(3,"sky","asrani","sky_baba","skybaba");
//		//System.out.println(user);
//		//userRepository.save(user);
//		
//		Set<UserSession> setUserSession=new HashSet<UserSession>();
//		setUserSession.add(userSession);
////		for (UserSession s : setUserSession) {
////			System. out. println(s);
////			}
//		
//		user.setUserSession(setUserSession);
//		
//		//System.out.println(user);
//		userRepository.save(user);
//		
//		userSession.setUser(user);
//		userSessionRepository.save(userSession);

		
	}

}
