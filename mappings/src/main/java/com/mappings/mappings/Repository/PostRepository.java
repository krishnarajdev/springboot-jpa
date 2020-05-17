package com.mappings.mappings.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.mappings.Domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByTitle(String title);
}
