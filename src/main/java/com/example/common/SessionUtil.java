package com.example.common;

import jakarta.servlet.http.HttpSession;

import com.example.dto.*;

public class SessionUtil {
  
  private static String SESSON_NAME_LOGIN = "loginResult";
  
  public void SetLoginSession(HttpSession session,
    ServiceResultDto<UsersDto> loginResult) {
      session.setAttribute(SESSON_NAME_LOGIN, loginResult.data());
  }
}