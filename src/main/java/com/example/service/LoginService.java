package com.example.service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.entity.*;
import com.example.repository.*;
import com.example.dto.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UsersRepository usersRepository;

    public ServiceResult<UsersDto> login(LoginRequestDto request) {
        Optional<Users> user = repo.findByName(request.username());
    
        if (user.isEmpty()) {
            return new ServiceResult<UsersDto>(false, null, "ユーザーが存在しません");
        }
    
        if (!user.get().getPassword().equals(request.password())) {
            return new ServiceResult<UsersDto>(false, null, "パスワードが違います");
        }
    
        UsersDto dto = new UsersDto(
                user.get().getId(),
                user.get().getName());
    
        return new ServiceResult<UsersDto>(true, dto, null);
    }
}