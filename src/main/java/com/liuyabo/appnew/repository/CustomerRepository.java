package com.liuyabo.appnew.repository;

import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from Customer where Id=1?", nativeQuery = true)
    Customer getCustomerById(int customerId);
    @Query(value = "select * from Customer where BossId=1? and Phone=2?", nativeQuery = true)
    Customer getCustomerByPhone(int bossId, String phone);
}
