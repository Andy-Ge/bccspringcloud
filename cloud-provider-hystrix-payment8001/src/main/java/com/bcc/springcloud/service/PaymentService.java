package com.bcc.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName:PaymentService
 * @Author:Andy-ge
 * @Date:2021/6/20 23:22
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"PaymentInfo_OK,id:"+id+"\t"+"成功";
    }

   // @HystrixCommand(fallbackMethod = "",commandProperties = {@HystrixProperty(name = "",value = "")})
    public String paymentInfo_TimeOut(Integer id) {

        int timeNumber = 5000;
//         int timeNumber = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " PaymenyInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~" + " 耗时" + timeNumber + "毫秒";
    }
}
