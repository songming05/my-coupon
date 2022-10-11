package me.songming.coupon.api.web;

import java.util.List;

public class SongCouponRetrievedListResult {
    public final String url;
    public final boolean hasMore;
    public final List<SongCouponRetrievedResult> data;

    public SongCouponRetrievedListResult(String url, boolean hasMore, List<SongCouponRetrievedResult> data) {
        this.url = url;
        this.hasMore = hasMore;
        this.data = data;
    }

    //{
    //  "object": "list",
    //  "url": "/v1/coupons",
    //  "has_more": false,
    //  "data": [
    //    {
    //      "id": "Z4OV52SU",
    //      "object": "coupon",
    //      "amount_off": null,
    //      "created": 1665403826,
    //      "currency": "usd",
    //      "duration": "repeating",
    //      "duration_in_months": 3,
    //      "livemode": false,
    //      "max_redemptions": null,
    //      "metadata": {},
    //      "name": "25.5% off",
    //      "percent_off": 25.5,
    //      "redeem_by": null,
    //      "times_redeemed": 0,
    //      "valid": true
    //    },
    //    {...},
    //    {...}
    //  ]
    //}
}
