package com.bcc.springcloud.dao;

import com.bcc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:Payment
 * @Author:Andy-ge
 * @Date:2021/5/27 23:46
 */

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}