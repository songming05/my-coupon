package me.songming.coupon.repository;

import me.songming.coupon.common.SongCouponId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SongCouponRepository {
    private Map<String, SongCouponEntity> database = new ConcurrentHashMap<>();  // db를 대체할 Map, 멀티쓰레드환경에서는 ConcurrentHashMap

    public void save(SongCouponId couponId) {
        database.put(couponId.value, new SongCouponEntity(couponId));
    }

    public SongCouponEntity retrieve(SongCouponId couponId) {
        SongCouponEntity songCouponEntity = Optional.ofNullable(database.get(couponId.value))
                .orElseThrow(() -> new IllegalArgumentException("해당하는 id가 없습니다."));
        return songCouponEntity;
    }

    public List<SongCouponEntity> retrieveList(String limit) {
        int count = Integer.parseInt(limit);
        List<SongCouponEntity> retrieveResults = new ArrayList<>();
        for (String s : database.keySet()) {
            if(retrieveResults.size() >= count) break;
            retrieveResults.add(database.get(s));
        }
        return retrieveResults;
    }
}
