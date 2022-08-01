package me.zilzu.mycoupon.api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.zilzu.mycoupon.application.service.Coupon;

public class CouponCreatedResponse {

    public String id;
    public String object;
    @JsonProperty("amount_off")
    public Integer amountOff;
    public long created;
    public String currency;
    public String duration;
    @JsonProperty("duration_in_months")
    public Integer durationInMonths;
    public Boolean livemode;
    @JsonProperty("max_redemptions")
    public Integer maxRedemptions;
    public String name;
    @JsonProperty("percent_off")
    public Float percentOff;
    public Boolean valid;

    public CouponCreatedResponse(Coupon coupon) {
        this.id = coupon.id;
        this.object = coupon.object;
        this.amountOff = coupon.amountOff;
        this.created = coupon.created;
        this.currency = coupon.currency;
        this.duration = coupon.duration;
        this.durationInMonths = coupon.durationInMonths;
        this.livemode = coupon.livemode;
        this.maxRedemptions = coupon.maxRedemptions;
        this.name = coupon.name;
        this.percentOff = coupon.percentOff;
        this.valid = coupon.valid;
    }
}
