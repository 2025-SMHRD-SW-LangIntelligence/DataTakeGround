package com.smhrd.dtg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smhrd.dtg.entity.User;

public interface TestRepository extends JpaRepository<User, Long> {
}
