package me.songming.coupon.api.web;

import me.songming.coupon.common.SongCouponSearchCondition;
import me.songming.coupon.application.service.SongCouponService;
import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SongCouponController {

    private final SongCouponService songCouponService;

    public SongCouponController(SongCouponService songCouponService) {
        this.songCouponService = songCouponService;
    }

    @GetMapping("/api/s1/coupons/{id}")
    public SongCouponRetrievedResult retrieveCoupon(@PathVariable String id) {
        SongCouponId songCouponId = new SongCouponId(id);
        SongCoupon songCoupon = songCouponService.retrieve(songCouponId);
        return new SongCouponRetrievedResult(songCoupon);
    }

    @GetMapping("/api/s1/coupons")
    public SongCouponRetrievedListResult retrieveCouponList(@RequestParam(required = false) String limit, HttpServletRequest request) {
        // 추후 페이지
        // 유효기간, user id 조건 등
        //return many coupons
        String defaultLimit = Optional.ofNullable(limit).orElse("20");
        boolean isNumeric = defaultLimit.matches("[0-9]+");
        if(!isNumeric) throw new IllegalArgumentException("올바른 입력이 아닙니다.");

        SongCouponSearchCondition songCouponSearchCondition = new SongCouponSearchCondition(limit);
        List<SongCoupon> songCouponList = songCouponService.retrieveList(songCouponSearchCondition);
        SongCouponRetrievedListResult songCouponRetrievedListResult = new SongCouponRetrievedListResult(request.getRequestURI(),
                true, songCouponList.stream()
                .map(SongCouponRetrievedResult::new)
                .collect(Collectors.toList())
        );
        return songCouponRetrievedListResult;
    }
}
