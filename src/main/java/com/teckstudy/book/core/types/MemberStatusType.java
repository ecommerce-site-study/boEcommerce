package com.teckstudy.book.core.types;

import lombok.Getter;

@Getter
public enum MemberStatusType {
    NORMAL("일반", "1"),
    BLOCK("정지", "2");

    private String legacyName;
    private String legacyCode;

    MemberStatusType(String legacyName, String legacyCode) {
        this.legacyName = legacyName;
        this.legacyCode = legacyCode;
    }
}
