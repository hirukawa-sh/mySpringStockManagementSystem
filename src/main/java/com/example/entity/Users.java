package com.example.entity;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "users")
public class Users {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "ユーザー名は必須です")
    @Size(max = 50, message = "50文字以内で入力してください")
    private String name;
    
    @NotBlank(message = "パスワードは必須です")
    @Size(max = 20, message = "20文字以内で入力してください")
    private String password;
    
}