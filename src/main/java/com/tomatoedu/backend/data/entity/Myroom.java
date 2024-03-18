package com.tomatoedu.backend.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "myroom")
@NoArgsConstructor
public class Myroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "lec_id", referencedColumnName = "lec_id")
    private Lecture lecture;

}
