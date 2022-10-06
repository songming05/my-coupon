package me.songming.coupon.application.service;

import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<SongCoupon> retrieveList(@NonNull String limit) {
        Objects.nonNull(limit);
        List<SongCouponEntity> couponEntityList = songCouponRepository.retrieveList(limit);

        return couponEntityList.stream()
                .map((couponEntity ->
                        new SongCoupon(couponEntity.id, couponEntity.amountOff, couponEntity.percentOff, couponEntity.valid)))
                .collect(Collectors.toList());
    }
}
