package com.test.book.svc;

import com.test.book.domain.User;
import com.test.book.domain.UserRepository;
import com.test.book.dto.UserDto;
import com.test.book.vo.UserVo;
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

    public UserDto.loginRes login(User user) {
        User rawUser = userRepository.findByUserid(user.getUserid());

        //if(rawUser != null && rawUser.getPassword().equals(user.getPassword()))

        if(rawUser != null && bCryptPasswordEncoder.matches(user.getPassword(),rawUser.getPassword()))
        {
            return UserDto.loginRes.builder()
                    .msg("로그인 성공")
                    .result(true)
                    .build();

        }
        return UserDto.loginRes.builder()
                .msg("로그인 실패")
                .result(false)
                .build();
    }

    public String postUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        log.debug("Password :: {}",user.getPassword());
        userRepository.save(user);
        return null;
    }
}
