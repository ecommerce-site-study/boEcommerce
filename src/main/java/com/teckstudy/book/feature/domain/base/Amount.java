package com.teckstudy.book.feature.domain.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Amount {

    public static final Amount ZERO = Amount.of(0L);

    @Column
    private BigDecimal price;

    protected Amount() {}

    public Amount(final BigDecimal price) {
        validate(price);
        this.price = price;
    }

    public static Amount of(int price) {
        return new Amount(BigDecimal.valueOf(price));
    }

    public static Amount of(long price) {
        return new Amount(BigDecimal.valueOf(price));
    }

    public static Amount of(BigDecimal price) {
        return new Amount(price);
    }

    public Amount add(Amount other) {
        return new Amount(this.price.add(other.price));
    }

    public Amount subtract(Amount other) {
        return new Amount(this.price.subtract(other.getValue()));
    }

    public Amount multiply(long count) {
        return new Amount(this.price.multiply(BigDecimal.valueOf(count)));
    }

    public BigDecimal getValue() {
        return this.price;
    }

    public int intValue() {
        return this.price.intValue();
    }

    public boolean isBiggerThan(Amount other) {
        return price.intValue() > other.getValue().intValue();
    }

    private void validate(BigDecimal Amount) {
        if (Amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("가격은 0 원 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount Amount1 = (Amount) o;
        return Objects.equals(price, Amount1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}