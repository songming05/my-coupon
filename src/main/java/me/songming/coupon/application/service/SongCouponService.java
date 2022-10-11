package me.songming.coupon.application.service;

import me.songming.coupon.api.web.SongCouponIdGenerator;
import me.songming.coupon.common.SongCouponSearchCondition;
import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<SongCoupon> retrieveList(SongCouponSearchCondition songCouponSearchCondition) {

        List<SongCouponEntity> songCouponEntityList =songCouponRepository.retrieveList(songCouponSearchCondition.limit);
        List<SongCoupon> songCouponList = songCouponEntityList.stream()
                .map(entity -> new SongCoupon(entity.id, 0, 0.0, true))
                .collect(Collectors.toList());
        return songCouponList;
    }
}
