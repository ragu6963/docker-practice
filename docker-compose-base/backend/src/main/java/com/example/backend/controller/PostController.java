package com.example.backend.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PostController {
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "성공",
					content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "잘못된 요청",
					content = @Content),
			@ApiResponse(responseCode = "500", description = "서버 오류",
					content = @Content)
	})

	@GetMapping("")
	public String Hello() {
		return "Hello World!";
	}

	@GetMapping("post")
	public String getPost() {
		return "Post";
	}

}
