package com.example.toyappspringboot.request_body;

import lombok.Data;

@Data
public class UpdateUserRequestBody {
  private String name;
  private String email;
}
