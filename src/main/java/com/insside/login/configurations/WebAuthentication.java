package com.insside.login.configurations;

import com.insside.login.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter{

    @Autowired
    UserRepository userRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userName -> {

            com.insside.login.models.User user1 = userRepository.findByUserName(userName);
            com.insside.login.models.User user2 = userRepository.findByUserName(userName);
            if (user1 != null) {
                if (user1.getuserName().equals("dulcire22")){
                    return new  org.springframework.security.core.userdetails.User(user1.getuserName(), user1.getPassword(),
                    AuthorityUtils.createAuthorityList("ADMIN"));
                }
                return new  org.springframework.security.core.userdetails.User(user1.getuserName(), user1.getPassword(), AuthorityUtils.createAuthorityList("USER"));
            } else if (user2 != null) {
                if (user2.getuserName().equals("flanocci22")){
                    return new  org.springframework.security.core.userdetails.User(user2.getuserName(), user2.getPassword(),
                    AuthorityUtils.createAuthorityList("OPERATOR"));
                }
                return new  org.springframework.security.core.userdetails.User(user2.getuserName(), user2.getPassword(), AuthorityUtils.createAuthorityList("USER"));
              }  else {
                throw new UsernameNotFoundException("final user: " + userName);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
