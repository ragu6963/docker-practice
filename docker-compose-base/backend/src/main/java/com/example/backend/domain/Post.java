package com.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 1000)
	private String content;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime updatedAt = LocalDateTime.now();
}