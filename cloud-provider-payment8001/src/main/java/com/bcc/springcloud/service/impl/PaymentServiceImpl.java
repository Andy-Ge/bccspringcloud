package com.bcc.springcloud.service.impl;

import com.bcc.springcloud.dao.PaymentDao;
import com.bcc.springcloud.entities.Payment;
import com.bcc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName:PaymentServiceImpl
 * @Author:Andy-ge
 * @Date:2021/6/6 23:17
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
