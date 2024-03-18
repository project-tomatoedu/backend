package com.tomatoedu.backend.data.entity;

import com.tomatoedu.backend.data.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor // 매개변수가 없는 기본 생성자
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(name = "member_type", length = 50, columnDefinition = "VARCHAR(1) DEFAULT 'S'")
    private String memberType;

    @Column(length = 100, unique = true)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String intro;

    @Column(name = "deleted_yn", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String deletedYn;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wish> wishes = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures= new ArrayList<>();

/*    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Myroom> myLectures = new ArrayList<>();*/

    /**
     * 회원 정보 등록시 사용
     * @param name
     * @param email
     * @param password
     * @param memberType
     * @param phone
     * @param password
     * @param intro
     * @param deletedYn
     */
    @Builder
    public Member(Long id, String name, String email, String password, String memberType, String phone, String intro, String deletedYn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.memberType = memberType;
        this.phone = phone;
        this.intro = intro;
        this.deletedYn = deletedYn;
    }

}
