package com.smhrd.ta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smhrd.ta.entity.User;

public interface TestRepository extends JpaRepository<User, Long> {
}
