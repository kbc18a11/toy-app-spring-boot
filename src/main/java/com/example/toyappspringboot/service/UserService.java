package com.example.toyappspringboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.toyappspringboot.model.User;
import com.example.toyappspringboot.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Transactional
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
}
