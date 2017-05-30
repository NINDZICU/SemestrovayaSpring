package ru.kpfu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.entities.UserJPA;
import ru.kpfu.repositories.AuthorityJPARepository;
import ru.kpfu.repositories.UserJPARepository;

/**
 * Created by Anatoly on 22.05.2017.
 */
public class UserService implements UserDetailsService {
    @Autowired
    UserJPARepository userJPARepository;
    @Autowired
    AuthorityJPARepository authorityJPARepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserJPA user = userJPARepository.findUserJPAByLogin(login);
        return user;
    }
    public void registerUser(UserJPA user) {
        if(userJPARepository.findUserJPAByLogin(user.getLogin()) != null){
            throw new DuplicateKeyException("Duplicate key - username field.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addAuthority(authorityJPARepository.findByAuthority("ROLE_USER"));
        userJPARepository.save(user);
    }

}
