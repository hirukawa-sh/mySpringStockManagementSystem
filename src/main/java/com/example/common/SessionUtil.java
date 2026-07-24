package com.example.common;

import jakarta.servlet.http.HttpSession;

import com.example.dto.*;

public class SessionUtil {
  
  private static String SESSON_NAME_LOGIN = "loginUser";
  
  /**
   * ログインセッション情報セット
   */
  public static void setLoginSession(HttpSession session,
    ServiceResultDto<UsersDto> loginResult) {
      session.setAttribute(SESSON_NAME_LOGIN, loginResult.data());
  }
  
  /**
   * ログインユーザー取得
   */
  public static UsersDto getLoginUser(HttpSession session) {
    return (UsersDto)session.getAttribute(SESSON_NAME_LOGIN);
  }
  
  /**
   * ログイン中か？
   */
  public static boolean isLogin(HttpSession session) {
    return false;
  }
}