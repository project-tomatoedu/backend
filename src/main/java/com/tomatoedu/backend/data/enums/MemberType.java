package com.tomatoedu.backend.data.enums;

/**
 * 회원타입
 * S: 학생, T: 강의자, A: 관리자
 * MemberType.FAX.getFaxNumberType() -> "학생"
 * MemberType.FAX.name() -> "S"
 */
public enum MemberType {
    S("그룹번호"),
    T("개인번호"),
    A("가상번호");

    final private String memberType;

    private MemberType(String memberType) { this.memberType = memberType; }

    public String getMemberType() { return memberType; }

}
