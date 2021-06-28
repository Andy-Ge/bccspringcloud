package com.bcc.springcloud.controller;

import com.bcc.springcloud.entities.CommonResult;
import com.bcc.springcloud.entities.Payment;
import com.bcc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName:OrderFeignController
 * @Author:Andy-ge
 * @Date:2021/6/20 1:33
 */

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("ddd");
        log.info("测试提交");
        return paymentFeignService.getPaymentById(id);

    }

}
