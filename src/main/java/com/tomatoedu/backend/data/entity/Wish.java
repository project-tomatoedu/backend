package com.tomatoedu.backend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "wish")
@NoArgsConstructor
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_id")
    private Long id;

    @ManyToOne // 찜한 회원
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @ManyToOne // 찜한 강좌
    @JoinColumn(name = "lec_id", referencedColumnName = "lec_id")
    private Lecture lecture;

}
