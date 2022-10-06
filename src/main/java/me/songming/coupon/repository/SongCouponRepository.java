package me.songming.coupon.repository;

import me.songming.coupon.api.web.SongCouponIdGenerator;
import me.songming.coupon.common.SongCouponId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class SongCouponRepository {
    private Map<String, SongCouponEntity> database = new ConcurrentHashMap<>();  // db를 대체할 Map, 멀티쓰레드환경에서는 ConcurrentHashMap

    @PostConstruct
    private void makeSomeFakeDatas() {
        for (int i = 0; i < 30; i++) {
            SongCouponId songCouponId = new SongCouponId(SongCouponIdGenerator.randomIdGenerate());
            int amountOff = (int) Math.random() * 100;
            double percentOff =  Math.random();
            SongCouponEntity songCouponEntity = new SongCouponEntity(songCouponId, amountOff, percentOff, true);
            database.put(songCouponId.value, songCouponEntity);
        }
    }

    public void save(SongCouponId couponId) {
        int amountOff = 0;
        double percentOff = 0.0;
        boolean valid = true;
        database.put(couponId.value, new SongCouponEntity(couponId, amountOff, percentOff, valid));
    }

    public SongCouponEntity retrieve(SongCouponId couponId) {
        SongCouponEntity songCouponEntity = Optional.ofNullable(database.get(couponId.value))
                .orElseThrow(() -> new IllegalArgumentException("해당하는 id가 없습니다."));
        return songCouponEntity;
    }

    public List<SongCouponEntity> retrieveList(String limit) {
        return database.keySet().stream()
                .limit(Long.parseLong(limit))
                .map(key -> database.get(key))
                .collect(Collectors.toList());
    }
}
