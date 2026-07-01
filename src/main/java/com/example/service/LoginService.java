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

    public UsersDto login(LoginRequestDto request) {

        Users user = usersRepository.findByName(request.username())
                .orElseThrow(() ->
                        new IllegalArgumentException("ユーザーが存在しません"));

        if (!user.getPassword().equals(request.password())) {
            throw new IllegalArgumentException("パスワードが違います");
        }

        return new UsersDto(
                user.getId(),
                user.getName()
        );
    }
}