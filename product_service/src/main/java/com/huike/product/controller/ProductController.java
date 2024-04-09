package com.huike.product.controller;

import com.huike.product.entity.Product;
import com.huike.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;


	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
//		try {
//			Thread.sleep(2000l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		Product product = productService.findById(id);
		return product;
	}
}
