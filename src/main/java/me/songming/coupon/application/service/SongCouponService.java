package me.songming.coupon.application.service;

import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import org.springframework.stereotype.Service;

@Service
public class SongCouponService {
    private final SongCouponRepository songCouponRepository;

    public SongCouponService(SongCouponRepository songCouponRepository) {
        this.songCouponRepository = songCouponRepository;
    }

    public SongCouponEntity retrieve(String id) {
        SongCouponEntity songCouponEntity = songCouponRepository.retrieve(id);
        return songCouponEntity;
    }
}
