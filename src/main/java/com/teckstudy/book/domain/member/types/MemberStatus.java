package com.teckstudy.book.domain.member.types;

import lombok.Getter;

@Getter
public enum MemberStatus {
    NORMAL("일반", "1"),
    BLOCK("정지", "2");

    private String legacyName;
    private String legacyCode;

    MemberStatus(String legacyName, String legacyCode) {
        this.legacyName = legacyName;
        this.legacyCode = legacyCode;
    }
}
