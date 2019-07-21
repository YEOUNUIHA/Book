package com.test.book.svc;

import com.test.book.domain.User;
import com.test.book.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean login(User user) {
        User checkUser = userRepository.findByUserid(user.getUserid());
        if(checkUser == null)
            return false;
        String password =checkUser.getPassword();
        return bCryptPasswordEncoder.matches(user.getPassword(),password);
    }

    public void postUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        log.debug("password : {}", user.getPassword());
        userRepository.save(user);
    }

    public boolean idCheck(String userid){
        User checkUser = userRepository.findByUserid(userid);
        if(checkUser == null)
            return true;
        return false;
    }
}
