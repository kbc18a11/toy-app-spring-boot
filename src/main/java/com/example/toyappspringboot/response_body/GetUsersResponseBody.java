package com.example.toyappspringboot.response_body;

import java.util.List;
import com.example.toyappspringboot.model.User;
import lombok.Data;

@Data
public class GetUsersResponseBody {
  private List<User> users;
}
