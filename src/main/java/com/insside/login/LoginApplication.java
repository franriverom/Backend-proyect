package com.insside.login;

import com.insside.login.models.ProfileRole;
import com.insside.login.models.User;
import com.insside.login.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
		System.out.println("Bienvenido a LoginApp");
	}	

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(UserRepository userRepository){
		return (args) -> {
			User user1 = userRepository.save(new User("dulcire22", passwordEncoder.encode("Dulcire123%"), "Dulcire", "Chipre", 25, ProfileRole.ADMIN));
			User user2 = userRepository.save(new User("flanocci22", passwordEncoder.encode("Flanocci123%"), "Fabian", "Lanocci", 25, ProfileRole.OPERATOR));
			User user3 = userRepository.save(new User("smogames22", passwordEncoder.encode("Mogames123%"), "Samanta", "Mogames", 25, ProfileRole.FINALUSER));
		};
	}
}