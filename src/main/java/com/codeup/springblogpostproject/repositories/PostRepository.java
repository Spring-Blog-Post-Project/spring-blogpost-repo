package com.codeup.springblogpostproject.repositories;

import com.codeup.springblogpostproject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
}
