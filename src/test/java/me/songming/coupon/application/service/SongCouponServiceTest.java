package me.songming.coupon.application.service;

import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import me.zilzu.mycoupon.MyCouponApplication;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = MyCouponApplication.class)
class SongCouponServiceTest {

    SongCouponService songCouponService;

    SongCouponRepository songCouponRepository;

    @BeforeEach
    public void virtual_database_init() {
        songCouponRepository = new SongCouponRepository();
        songCouponService = new SongCouponService(songCouponRepository);
        for (int i = 0; i < 10; i++) {
            songCouponRepository.save(new SongCouponId(String.valueOf(i)));
        }
    }

    @Test
    void retrieve_coupon_by_id() {
        SongCoupon songCoupon = songCouponService.retrieve(new SongCouponId("1"));
        assertThat(songCoupon).isNotNull();
        System.out.println("songCoupon = " + songCoupon);
        assertThatThrownBy(() -> songCouponService.retrieve(new SongCouponId("99")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}