package com.codeup.springblogpostproject.repositories;

import com.codeup.springblogpostproject.models.Post;
import com.codeup.springblogpostproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
}
