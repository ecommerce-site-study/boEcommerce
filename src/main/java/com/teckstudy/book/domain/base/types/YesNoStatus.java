package com.teckstudy.book.domain.base.types;

import lombok.Getter;

@Getter
public enum YesNoStatus {
    Y, N;

    public boolean isY() {
        return this == Y;
    }

    public boolean isN() {
        return !isY();
    }
}
