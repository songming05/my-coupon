package me.zilzu.mycoupon.application.service;

import me.zilzu.mycoupon.common.enums.CouponCurrency;
import me.zilzu.mycoupon.common.enums.CouponDuration;

import java.time.LocalDateTime;
import java.util.Objects;

public class Coupon {
    public final String id;
    public final CouponDuration duration;
    public final Integer duration_in_month;
    public final CouponCurrency couponCurrency;
    public final LocalDateTime createdTime;


    public Coupon(String id, CouponDuration duration, Integer duration_in_month, CouponCurrency couponCurrency, LocalDateTime createdTime) {
        this.id = id;
        this.duration = duration;
        this.duration_in_month = duration_in_month;
        this.couponCurrency = couponCurrency;
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (!Objects.equals(id, coupon.id)) return false;
        if (!Objects.equals(duration, coupon.duration)) return false;
        if (couponCurrency != coupon.couponCurrency) return false;
        return Objects.equals(createdTime, coupon.createdTime);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (couponCurrency != null ? couponCurrency.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id='" + id + '\'' + ", duration='" + duration + '\'' + ", couponCurrency=" + couponCurrency + ", createdTime=" + createdTime + '}';
    }
}
