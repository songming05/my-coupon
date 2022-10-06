package me.songming.coupon.repository;

import me.songming.coupon.common.SongCouponId;

public class SongCouponEntity {
    //JPA 고려
    public final SongCouponId id;
    public final int amountOff;
    public final double percentOff;
    public final boolean valid;

    public SongCouponEntity(SongCouponId id, int amountOff, double percentOff, boolean valid) {
        this.id = id;
        this.amountOff = amountOff;
        this.percentOff = percentOff;
        this.valid = valid;
    }
}
