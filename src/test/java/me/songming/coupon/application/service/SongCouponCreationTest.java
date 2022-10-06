package me.songming.coupon.application.service;

import me.songming.coupon.SongmingPackageScan;
import me.songming.coupon.api.web.SongCouponIdGenerator;
import me.zilzu.mycoupon.MyCouponApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {MyCouponApplication.class, SongmingPackageScan.class})
public class SongCouponCreationTest {

    @Autowired
    SongCouponService songCouponService;

    @Test
    void id_generate() {
        //case1
        String couponId = SongCouponIdGenerator.randomIdGenerate();
        String couponId1 = SongCouponIdGenerator.randomIdGenerate();
        //new SongCouponId(new SongCouponIdGenerator());
        assertThat(couponId).isNotNull();
        assertThat(couponId1).isNotNull();
        assertThat(couponId).isNotEqualTo(couponId1);

        System.out.println("couponId = " + couponId);
        System.out.println("couponId1 = " + couponId1);

    }
//    void coupon_create_env_of_multiThread(){
//        couponCreateOnMultiThread(10000, 100);
//        // Test Worker Thread
//        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
//        assertThat(songCouponService.getAllCouponSize()).isEqualTo(10000);
//
//    }
//
//
//    void couponCreateOnMultiThread(int count, int nThreads) {
//        CouponCreationRequest couponCreationRequest = new CouponCreationRequest(CouponDuration.ONCE, null, null, null, null);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(nThreads); // threadPoolSize 100
//
//        List<CompletableFuture> completableFutureList = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            CompletableFuture<Void> completableFuture = (CompletableFuture<Void>) executorService.submit(() -> {
//                songCouponService.create(couponCreationRequest);
//            });
//            completableFutureList.add(completableFuture);
//        }
//        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();
//
//        executorService.shutdown();
//    }
}
