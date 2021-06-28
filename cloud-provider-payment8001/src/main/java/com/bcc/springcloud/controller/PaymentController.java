package com.bcc.springcloud.controller;

import com.bcc.springcloud.entities.CommonResult;
import com.bcc.springcloud.entities.Payment;
import com.bcc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName:PaymentController
 * @Author:Andy-ge
 * @Date:2021/6/6 23:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入结果：***"+result);

        if(result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***查询结果：***"+payment);

        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"无对应记录，查询ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/disvovery")
    public Object discovery(){
        List<String>  services = discoveryClient.getServices();
        Iterator ser = services.iterator();
        while (ser.hasNext()){
            log.info("**************ser:"+ser.next());
        }

        List<ServiceInstance> instance =  discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        Iterator<ServiceInstance> ins = instance.iterator();
        while (ins.hasNext()){
            ServiceInstance s = ins.next();
            log.info("*********instance:"+s.getHost()+"/t"+s.getInstanceId()+"/t"+s.getServiceId()+"/t"+s.getPort());
        }
        return this.discoveryClient;
    }

    @RequestMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
