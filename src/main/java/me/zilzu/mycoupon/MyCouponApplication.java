package me.zilzu.mycoupon;

import me.songming.coupon.SongmingPackageScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {MyCouponApplication.class, SongmingPackageScan.class})
@SpringBootApplication
public class MyCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCouponApplication.class, args);
    }

}