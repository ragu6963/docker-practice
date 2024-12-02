package com.example.backend.controller;

import com.example.backend.dto.ArticleRequestDto;
import com.example.backend.dto.ArticleResponseDto;
import com.example.backend.service.ArticleService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ArticleController {
	private final ArticleService articleService;

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


	@GetMapping("articles")
	public List<ArticleResponseDto> getArticles() {
		return articleService.getArticles();
	}

	@PostMapping("articles")
	public ArticleResponseDto createArticle(@RequestBody ArticleRequestDto requestDto) {
		return articleService.createArticle(requestDto);
	}

}
