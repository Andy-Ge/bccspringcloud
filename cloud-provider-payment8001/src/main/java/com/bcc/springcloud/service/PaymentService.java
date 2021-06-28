package com.bcc.springcloud.service;

import com.bcc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName:PaymentService
 * @Author:Andy-ge
 * @Date:2021/6/6 23:13
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
