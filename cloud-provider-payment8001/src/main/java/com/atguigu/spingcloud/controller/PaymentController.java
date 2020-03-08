package com.atguigu.spingcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;

import com.atguigu.spingcloud.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chenchen
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return  new CommonResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        log.info("xxx");
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return  new CommonResult(444,"没有对应记录，查询Id:"+id,null);
        }
    }
}
