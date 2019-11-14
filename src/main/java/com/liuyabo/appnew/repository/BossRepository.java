package com.liuyabo.appnew.repository;

import com.liuyabo.appnew.entity.Boss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long> {
    @Query(value= "select * from Boss where id=?1", nativeQuery = true)
    Boss findById(int id);

    @Query(value="select * from Boss where phone=1?", nativeQuery = true)
    Boss findByPhone(String phone);

    @Query(value = "update Boss set Status=1? where Id=2?", nativeQuery = true)
    Boss deactiveBoseById(int id, String status);

}
