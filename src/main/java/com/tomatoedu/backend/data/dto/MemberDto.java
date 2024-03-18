package com.tomatoedu.backend.data.dto;

import com.tomatoedu.backend.data.entity.Member;
import com.tomatoedu.backend.data.enums.MemberType;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MemberDto {

    private Long id;
    private String name; // 이름
    private String password; // 비밀번호
    private String memberType; // 회원타입 [S:학생, T:강사, A:관리자]
    private String phone; // 연락처
    private String intro; // 소개
    private LocalDateTime createdDate; // 가입일시
    private String deletedYn; // 탈퇴여부

    /**
     * setter 메서드 호출 없이 빌더 통해 객체 생성 가능
     * MemberDto dto = MemberDto.builder()
     *     .id("123")
     *     .build();
     */
    @Builder
    public static MemberDto newInstance(Long id, String name, String password, String memberType, String phone, String intro, LocalDateTime createdDate, String deletedYn) {
        MemberDto memberDto = new MemberDto();
        memberDto.id = id;
        memberDto.name = name;
        memberDto.password = password;
        memberDto.memberType = memberType;
        memberDto.phone = phone;
        memberDto.intro = intro;
        memberDto.createdDate = createdDate;
        memberDto.deletedYn = deletedYn;
        return memberDto;
    }

    /**
     * 사용자 Entity -> Dto
     * @param member
     * @return MemberDto
     */
    public static MemberDto toDto(Member member) {
        return MemberDto.newInstance(
                member.getId(),
                member.getName(),
                member.getPassword(),
                member.getMemberType(),
                member.getPhone(),
                member.getIntro(),
                member.getCreatedDate(),
                member.getDeletedYn()
        );
    }

    /**
     * 사용자 Dto -> Entity
     * @param memberDto
     * @return Member
     */
    public static Member toEntity(MemberDto memberDto) {
        return Member.builder()
                .id(memberDto.getId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .memberType(memberDto.getMemberType())
                .phone(memberDto.getPhone())
                .intro(memberDto.getIntro())
                .deletedYn(memberDto.getDeletedYn())
                .build();
    }

    public String getStringMemberType() {
        return MemberType.valueOf(this.memberType).getMemberType();
    }

}
