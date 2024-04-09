package com.huike.order.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.huike.order.entity.Product;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class ExceptionUtils {
    /**
     * 静态方法
     * <p>
     * 返回值: SentinelClientHttpResponse
     * <p>
     * }
     * 参数 : request , byte[] , clientRquestExcetion , blockException
     */
    //限流熔断业务逻辑
    public static SentinelClientHttpResponse handleBlock(HttpRequest request,
                                                         byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        Product product = new Product();
        product.setProductName("block");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }

    //异常降级业务逻辑
    public static SentinelClientHttpResponse handleFallback(HttpRequest request,
                                                            byte[] body,
                                                            ClientHttpRequestExecution execution, BlockException ex) {
        Product product = new Product();
        product.setProductName("fallback");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }
}