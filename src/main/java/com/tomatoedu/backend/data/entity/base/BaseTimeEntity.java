package com.tomatoedu.backend.data.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
 * JPA Auditing 기능
 * 이벤트(예: 생성, 수정)가 발생할 때 이벤트를 처리할 리스너를 지정하는 데 사용
 * AuditingEntityListener.class는 JPA Auditing의 리스너 클래스를 지정
 */

@Getter
@ToString
@NoArgsConstructor
@MappedSuperclass // 부모클래스의 매핑 정보만 상속 | 테이블로 매핑되지 않고 다른 엔티티 클래스에서만 상속하여 사용
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 기능 활성화
public class BaseTimeEntity {

    @CreatedDate // Entity 생성시 자동으로 생성일시 기록
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createdDate;

    // @LastModifiedDate Entity 생성시 자동으로 수정일시 기록

}

