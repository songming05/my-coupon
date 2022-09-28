package me.songming.coupon.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("songmingCouponController")
public class CouponController {

    @GetMapping("/api/s1/coupons/{id}")
    public String retrieveCoupon(@PathVariable String id) {
        //return one-coupon
        return id;
    }

    @GetMapping("/api/s1/coupons/list")
    public String retrieveCouponList() {
        // limit
        // 추후 페이지
        // 유효기간, user id 조건 등
        //return many coupons

        return "coupon list";
    }
}
