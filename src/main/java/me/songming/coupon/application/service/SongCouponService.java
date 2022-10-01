package me.songming.coupon.application.service;

import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import org.springframework.stereotype.Service;

@Service
public class SongCouponService {
    private final SongCouponRepository songCouponRepository;

    public SongCouponService(SongCouponRepository songCouponRepository) {
        this.songCouponRepository = songCouponRepository;
    }

    public SongCoupon retrieve(SongCouponId couponId) {
        SongCouponEntity songCouponEntity = songCouponRepository.retrieve(couponId);
        SongCoupon songCoupon = new SongCoupon(songCouponEntity.id, 0, 0.0, true);
        return songCoupon;
    }
}
