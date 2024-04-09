package com.huike.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.huike.order.entity.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @SentinelResource(value = "orderFindById", blockHandler = "orderBlockHandler", fallback = "orderFallback")
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) {
        if (id != 2) {
            throw new RuntimeException("错误");
        }
        return restTemplate.getForObject("http://service-product/product/" + id, Product.class);
    }


    public Product orderBlockHandler(Long id) {
        Product product = new Product();
        product.setProductName("触发熔断的降级方法");
        return product;
    }

    public Product orderFallback(Long id) {
        Product product = new Product();
        product.setProductName("抛出异常执行的降级方法");
        return product;
    }

}
