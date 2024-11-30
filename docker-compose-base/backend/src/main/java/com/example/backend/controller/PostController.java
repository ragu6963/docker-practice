package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PostController {
  
  @GetMapping("")
  public String Hello() {
      return new String("Hello WORLD");
  }
  
}

