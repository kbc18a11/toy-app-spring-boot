package com.example.toyappspringboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.toyappspringboot.model.User;
import com.example.toyappspringboot.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザー登録
   */
  public void create(User user) {
    userRepository.create(user);
  }

  /**
   * ユーザーレコードすべて取得
   * 
   * @return
   */
  public List<User> findAll() {
    return userRepository.findAll();
  }

  /**
   * ユーザー情報更新
   * 
   * @param user
   */
  public void update(User user) {
    userRepository.update(user);
  }
}
