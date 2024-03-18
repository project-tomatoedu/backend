package com.tomatoedu.backend.data.dto;

import com.tomatoedu.backend.data.entity.Member;
import com.tomatoedu.backend.data.entity.Profile;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProfileDto {

    private Long id;
    private Long memberId;
    private String filePath; // 프로필 경로
    private String fileName; // 프로필 이름

    /**
     * setter 메서드 호출 없이 빌더 통해 객체 생성 가능
     * MemberDto dto = MemberDto.builder()
     *     .id("1")
     *     .build();
     */
    @Builder
    public static ProfileDto newInstance(Long id, Long memberId, String filePath, String fileName) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.id = id;
        profileDto.memberId = memberId;
        profileDto.filePath = filePath;
        profileDto.fileName = fileName;
        return profileDto;
    }

    /**
     * 사용자 Entity -> Dto
     * @param profile
     * @return ProfileDto
     */
    public static ProfileDto toDto(Profile profile) {
        return ProfileDto.newInstance(
                profile.getId(),
                profile.getMember().getId(),
                profile.getFilePath(),
                profile.getFileName()
        );
    }

    /**
     * 사용자 Dto -> Entity
     * @param profileDto
     * @return Member
     */
    public static Profile toEntity(ProfileDto profileDto) {
        return Profile.builder()
                .id(profileDto.getId())
                .member(Member.builder().id(profileDto.getMemberId()).build())
                .filePath(profileDto.getFilePath())
                .fileName(profileDto.getFileName())
                .build();
    }
    
}
