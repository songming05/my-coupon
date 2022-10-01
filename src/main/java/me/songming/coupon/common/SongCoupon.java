package me.songming.coupon.common;

public class SongCoupon {

    //{
    //  "id": "Z4OV52SU",
    //  "object": "coupon",
    //  "amount_off": null,
    //  "created": 1664367400,
    //  "currency": "usd",
    //  "duration": "repeating",
    //  "duration_in_months": 3,
    //  "livemode": false,
    //  "max_redemptions": null,
    //  "metadata": {},
    //  "name": "25.5% off",
    //  "percent_off": 25.5,
    //  "redeem_by": null,
    //  "times_redeemed": 0,
    //  "valid": true
    //}

    public final SongCouponId id;
    public final int amountOff;
    public final double percentOff;
    public final boolean valid;


    public SongCoupon(SongCouponId id, int amountOff, double percentOff, boolean valid) {
        this.id = id;
        this.amountOff = amountOff;
        this.percentOff = percentOff;
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "SongCoupon{" +
                "id=" + id.value +
                ", amountOff=" + amountOff +
                ", percentOff=" + percentOff +
                ", valid=" + valid +
                '}';
    }
}
