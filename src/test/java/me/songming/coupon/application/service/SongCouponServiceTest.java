package me.songming.coupon.application.service;

import me.songming.coupon.api.web.SongCouponIdGenerator;
import me.songming.coupon.common.SongCoupon;
import me.songming.coupon.common.SongCouponId;
import me.songming.coupon.common.SongCouponSearchCondition;
import me.songming.coupon.repository.SongCouponEntity;
import me.songming.coupon.repository.SongCouponRepository;
import me.zilzu.mycoupon.MyCouponApplication;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.List;

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
        for (int i = 0; i < 45; i++) {
            songCouponRepository.save(new SongCouponId(SongCouponIdGenerator.randomIdGenerate()));
        }
    }

    @Test
    @DisplayName("id를 통해 하나의 쿠폰을 조회한다.")
    void retrieve_coupon_by_id() {
        SongCoupon songCoupon = songCouponService.retrieve(new SongCouponId("1"));
        assertThat(songCoupon).isNotNull();
        System.out.println("songCoupon = " + songCoupon);
        assertThatThrownBy(() -> songCouponService.retrieve(new SongCouponId("99")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("limit 개수(optional) 파라미터를 활용하여 쿠폰 리스트를 조회한다.")
    void retrieve_coupon_list() {
        //before > coupon list insert
        SongCouponSearchCondition paramNull = new SongCouponSearchCondition(null);
        SongCouponSearchCondition paramEmpty = new SongCouponSearchCondition("");
        SongCouponSearchCondition param30 = new SongCouponSearchCondition("30");

        System.out.println("paramNull = " + paramNull.limit);
        System.out.println("paramEmpty = " + paramEmpty.limit);
        System.out.println("param30 = " + param30.limit);

        List<SongCoupon> defaultLimitList = songCouponService.retrieveList(paramNull);
        List<SongCoupon> defaultLimitList2 = songCouponService.retrieveList(paramEmpty);
        List<SongCoupon> limit30List = songCouponService.retrieveList(param30);

        assertThat(defaultLimitList).isNotNull();
        assertThat(defaultLimitList2).isNotNull();
        assertThat(limit30List).isNotNull();
        assertThat(defaultLimitList.size()).isEqualTo(20);
        assertThat(defaultLimitList2.size()).isEqualTo(20);
        assertThat(limit30List.size()).isEqualTo(30);
    }

}