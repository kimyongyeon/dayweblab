package com.hello.dev.hellospring.temp.controller;

import com.hello.dev.hellospring.temp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/list")
    public List productList() {
        return productService.productList();
    }


}
