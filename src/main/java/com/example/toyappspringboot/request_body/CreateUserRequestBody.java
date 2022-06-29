package com.example.toyappspringboot.request_body;

import lombok.Data;

@Data
public class CreateUserRequestBody {
  private String name;
  private String email;
}
