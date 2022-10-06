package me.songming.coupon.api.web;

import org.apache.commons.lang3.RandomStringUtils;

public class SongCouponIdGenerator {
    private static final String CAPITAL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC = "0123456789";

    public static String randomIdGenerate() {

        String id = ""; // Z4OV52SU
        //1. 첫글자는 영어 대문자 그외는 영어 대문자 or 숫자(0-9)
        //2. 8자리
        id = RandomStringUtils.random(1, CAPITAL_ALPHABET)
                + RandomStringUtils.random(7, CAPITAL_ALPHABET.concat(NUMERIC));

        return id;
    }
}
