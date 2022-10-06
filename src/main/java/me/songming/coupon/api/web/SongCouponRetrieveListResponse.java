package me.songming.coupon.api.web;

import me.songming.coupon.common.SongCoupon;

import java.util.List;

public class SongCouponRetrieveListResponse {
    public final String url;
    public final boolean has_more;
    public final List<SongCouponRetrievedResult> data;

    public SongCouponRetrieveListResponse(String url, boolean has_more, List<SongCouponRetrievedResult> data) {
        this.url = url;
        this.has_more = has_more;
        this.data = data;
    }
}
