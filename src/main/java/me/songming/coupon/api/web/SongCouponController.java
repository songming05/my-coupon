package me.songming.coupon.api.web;

import me.songming.coupon.application.service.SongCouponService;
import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import org.springframework.web.bind.annotation.*;

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

        SongCoupon songCoupon = songCouponService.retrieve(new SongCouponId(id));
        return new SongCouponRetrievedResult(songCoupon);
    }

    @GetMapping("/api/s1/coupons")
    public SongCouponRetrieveListResponse retrieveCouponList(HttpServletRequest request, @RequestParam(name = "limit", required = false)  String limit) {
        String uri = request.getRequestURI();
        limit = Optional.ofNullable(limit).orElse("20");
        List<SongCoupon> couponList = songCouponService.retrieveList(limit);

        // 페이지 작업 시
        //boolean hasMore = songCouponService.retrieveNextListAvailable()

        List<SongCouponRetrievedResult> retrievedResults = couponList.stream()
                .map(SongCouponRetrievedResult::new)
                .collect(Collectors.toList());
        return new SongCouponRetrieveListResponse(uri, true, retrievedResults);
    }

    @PostMapping("/api/s1/coupons")
    public void createCoupon() {
        //SongCouponIdGenerator

    }
}
