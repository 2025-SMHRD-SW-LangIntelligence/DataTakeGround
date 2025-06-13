package com.smhrd.ta.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.smhrd.ta.repository.TestRepository;
import com.smhrd.ta.entity.User;

import java.util.List;

@Component
public class TestClass implements CommandLineRunner {

    private final TestRepository testRepository;

    // ✅ 생성자 직접 작성하여 의존성 주입
    public TestClass(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // ✅ 1. User 저장 테스트
        User user = new User("김현식");
        testRepository.save(user);
        System.out.println("저장 완료! User ID: " + user.getId());

        // ✅ 2. 전체 조회 테스트
        List<User> users = testRepository.findAll();
        System.out.println("전체 사용자 목록:");
        for (User u : users) {
            System.out.println("ID: " + u.getId() + ", Name: " + u.getName());
        }
    }
}
