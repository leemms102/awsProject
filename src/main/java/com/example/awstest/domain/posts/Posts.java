package com.example.awstest.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* Posts 클래스 */

@Getter
@NoArgsConstructor      // 기본 constructor 생성
@Entity         // Entity class에서는 절대 Setter를 만들지 않음: 값 변경이 필요한 경우 의도에 맞는 각각의 메소드 구현
public class Posts extends BaseTimeEntity {
        @Id     // PK
        @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto-increment되려면 추가해야함
        private Long id;

        @Column(length = 500, nullable = false)         // 추가 안해도 모든 필드는 column이지만 옵션 수정 위해 사용
        private String title;

        @Column(columnDefinition = "TEXT", nullable = false)
        private String content;

        private String author;

        @Builder        // 생성자 외에 객체를 생성하는 별도의 방법: 생성자와 다르게 필드 이름 명시
        public Posts(String title, String content, String author){
                this.title = title;
                this.content = content;
                this.author = author;
        }

        public void update(String title, String content) {
                this.title = title;
                this.content = content;
        }

}
