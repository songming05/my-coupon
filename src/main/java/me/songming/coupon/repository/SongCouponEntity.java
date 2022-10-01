package me.songming.coupon.repository;

import me.songming.coupon.common.SongCouponId;

public class SongCouponEntity {
    //JPA 고려
    public SongCouponId id;

    public SongCouponEntity(SongCouponId id) {
        this.id = id;
    }
}
