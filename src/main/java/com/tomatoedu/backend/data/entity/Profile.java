package com.tomatoedu.backend.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "profile")
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "profile_path")
    private String filePath;

    @Column(name = "profile_name")
    private String fileName;

    @Builder
    public Profile(Long id, Member member, String filePath, String fileName) {
        this.id = id;
        this.member = member;
        this.filePath = filePath;
        this.fileName = fileName;
    }

}
