package me.songming.coupon.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class SongCouponRepository {
    private Map<String, SongCouponEntity> database = new ConcurrentHashMap<>();  // db를 대체할 Map, 멀티쓰레드환경에서는 ConcurrentHashMap

    public void save(String id) {
        database.put(id, new SongCouponEntity(id));
    }

    public SongCouponEntity retrieve(String id) {
        SongCouponEntity songCouponEntity = Optional.ofNullable(database.get(id))
                .orElseThrow(() -> new IllegalArgumentException("해당하는 id가 없습니다."));
        return songCouponEntity;
    }
}
