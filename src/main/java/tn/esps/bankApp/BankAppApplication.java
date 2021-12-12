package tn.esps.bankApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tn.esps.bankApp.entities.Role;
import tn.esps.bankApp.entities.User;
import tn.esps.bankApp.services.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("PUT", "DELETE", "GET", "POST");
			}
		};
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_CLIENT"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//
//			userService.saveUser(new User(null, "mohamed", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "amine", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "john", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "syrine", "1234", new ArrayList<>()));
//
//			userService.addRoleToUser("mohamed", "ROLE_USER");
//			userService.addRoleToUser("mohamed", "ROLE_ADMIN");
//			userService.addRoleToUser("amine", "ROLE_CLIENT");
//			userService.addRoleToUser("john", "ROLE_CLIENT");
//			userService.addRoleToUser("john", "ROLE_MANAGER");
//			userService.addRoleToUser("syrine", "ROLE_CLIENT");
//			userService.addRoleToUser("syrine", "ROLE_MANAGER");
//
//		};
//	}



}
