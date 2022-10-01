package me.songming.coupon.api.web;

import me.songming.coupon.common.SongCoupon;

public class SongCouponRetrievedResult {
    public final String id;
    public final int amountOff;
    public final double percentOff;
    public final boolean valid;

    public SongCouponRetrievedResult(SongCoupon songCoupon) {
        this.id = songCoupon.id.value;
        this.amountOff = songCoupon.amountOff;
        this.percentOff = songCoupon.percentOff;
        this.valid = songCoupon.valid;
    }
}
