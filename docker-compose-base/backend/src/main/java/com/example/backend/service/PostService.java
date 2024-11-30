package com.example.backend.service;

import com.example.backend.domain.Post;
import com.example.backend.dto.PostRequestDto;
import com.example.backend.dto.PostResponseDto;
import com.example.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public PostResponseDto createPost(PostRequestDto requestDto) {


//		return toResponseDto(post);
		return null;
	}


	private PostResponseDto toResponseDto(Post post) {

		return null;
//		return PostResponseDto.builder()
//				.id(post.getId())
//				.title(post.getTitle())
//				.content(post.getContent())
//				.createdAt(post.getCreatedAt())
//				.updatedAt(post.getUpdatedAt())
//				.build();

	}
}