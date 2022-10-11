package me.songming.coupon.common;

import java.util.Optional;

public class SongCouponSearchCondition {
    public final String limit;

    private final String DEFAULT_LIMIT_COUNT = "20";

    public SongCouponSearchCondition(String limit) {
        String defaultOrLimit = Optional.ofNullable(limit).orElse(DEFAULT_LIMIT_COUNT);
        if(defaultOrLimit.isBlank()) defaultOrLimit = DEFAULT_LIMIT_COUNT;
        boolean isNumeric = defaultOrLimit.matches("[0-9]+");
        if(!isNumeric) throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        this.limit = defaultOrLimit;
    }

    //public final String sort;
    //public final LocalDateTime localDateTime;
}
