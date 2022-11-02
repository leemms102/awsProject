package com.example.awstest.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// @Repository 추가할 필요 없음
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // 조회 기능은 조건이 복잡하여 entity만 사용하는 것보다 mapper 프레임워크 사용
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
