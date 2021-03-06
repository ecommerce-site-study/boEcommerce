package com.teckstudy.book.domain.board.types;

public enum CategoryType {

    NOTICE("공지사항", "10"),
    FAQ("FAQ", "20"),
    EVENT("이벤트", "30"),
    QUESTIONS("1:1문의", "40"),
    ETC("기타", "50");

    private final String legacyName;
    private final String legacyCode;

    CategoryType(String legacyName, String legacyCode) {
        this.legacyName = legacyName;
        this.legacyCode = legacyCode;
    }

}
