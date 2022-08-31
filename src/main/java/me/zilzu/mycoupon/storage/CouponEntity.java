package me.zilzu.mycoupon.storage;


import me.zilzu.mycoupon.common.enums.CouponCurrency;
import me.zilzu.mycoupon.common.enums.CouponDuration;
import me.zilzu.mycoupon.common.enums.DiscountType;

import java.time.LocalDateTime;

public class CouponEntity {
    public final String id;
    public final CouponDuration duration;
    public final Integer durationInMonth;
    public final CouponCurrency couponCurrency;
    public final DiscountType discountType;
    public final Long amountOff;
    public final Float percentOff;
    public final LocalDateTime createdTime;

    public CouponEntity(String id, CouponDuration duration, Integer durationInMonth, CouponCurrency couponCurrency, DiscountType discountType, Long amountOff, Float percentOff, LocalDateTime createdTime) {
        this.id = id;
        this.duration = duration;
        this.durationInMonth = durationInMonth;
        this.couponCurrency = couponCurrency;
        this.discountType = discountType;
        this.amountOff = amountOff;
        this.percentOff = percentOff;
        this.createdTime = createdTime;
    }
}
