package com.test.book.svc;

import com.test.book.domain.User;
import com.test.book.domain.UserRepository;
import com.test.book.dto.UserDto;
import com.test.book.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto.loginRes login(User user) {
        User rawUser = userRepository.findByUserid(user.getUserid());
        if(rawUser != null && rawUser.getPassword().equals(user.getPassword()))
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
        userRepository.save(user);
        return null;
    }
}
