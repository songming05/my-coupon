package me.zilzu.mycoupon.application.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

@Component
public class CouponIdGenerate {

    private static final String CAPITAL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";

    // "Z4OV52SU"
    public String generate() {
        String prefix = RandomStringUtils.random(1, CAPITAL_ALPHABET);

        String body = RandomStringUtils.random(7, CAPITAL_ALPHABET + NUMERIC);

        return prefix + body;
    }
}
