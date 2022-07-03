package com.example.toyappspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import com.example.toyappspringboot.model.User;
import com.example.toyappspringboot.request_body.CreateUserRequestBody;
import com.example.toyappspringboot.response_body.GetUsersResponseBody;
import com.example.toyappspringboot.service.UserService;


@Controller
public class UsersController {

  @Autowired
  UserService userService;

  /**
   * ユーザー登録
   * 
   * @param requestBody
   * @return
   */
  @PostMapping(value = "/users/new")
  public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestBody requestBody) {
    // ユーザー登録用のインスタンスを作成。
    var user = new User();
    user.setName(requestBody.getName());
    user.setEmail(requestBody.getEmail());

    try {
      // ユーザー登録
      userService.create(user);

      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (Exception e) {
      System.err.println(e);

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  /**
   * ユーザー一覧取得
   * 
   * @param requestBody
   * @return
   */
  @GetMapping(value = "/users")
  public ResponseEntity<GetUsersResponseBody> getUsers() {

    try {
      var response = new GetUsersResponseBody();
      response.setUsers(userService.findAll());

      return new ResponseEntity<GetUsersResponseBody>(response, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();

      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
