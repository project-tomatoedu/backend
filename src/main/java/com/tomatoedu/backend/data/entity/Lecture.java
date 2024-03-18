package com.tomatoedu.backend.data.entity;

import com.tomatoedu.backend.data.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "lecture")
@NoArgsConstructor
public class Lecture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lec_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;*/

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "image_path", length = 500)
    private String imagePath;

    @Column(name = "deleted_yn", columnDefinition = "VARCHAR(1) DEFAULT 'N'")
    private String deletedYn;

    @Builder
    public Lecture(Long id, Member member, String title, String content, String imagePath, String deletedYn) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
        this.deletedYn = deletedYn;
    }

}
