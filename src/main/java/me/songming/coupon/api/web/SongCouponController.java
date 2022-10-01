package me.songming.coupon.api.web;

import me.songming.coupon.application.service.SongCouponService;
import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongCouponController {

    private final SongCouponService songCouponService;

    public SongCouponController(SongCouponService songCouponService) {
        this.songCouponService = songCouponService;
    }

    @GetMapping("/api/s1/coupons/{id}")
    public SongCouponRetrievedResult retrieveCoupon(@PathVariable String id) {

        SongCoupon songCoupon = songCouponService.retrieve(new SongCouponId(id));
        return new SongCouponRetrievedResult(songCoupon);
    }

    @GetMapping("/api/s1/coupons")
    public String retrieveCouponList() {
        // limit
        // 추후 페이지
        // 유효기간, user id 조건 등
        //return many coupons

        return "coupon list";
    }
}
