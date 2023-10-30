package com.hello.dev.hellospring.temp.service;

import com.hello.dev.hellospring.temp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List productList();
    void addProduct();
    void editProduct();
    void removeProduct();
    @Service
    @RequiredArgsConstructor
    class ProductServiceImpl implements ProductService {

        private final ProductRepository productRepository;


        @Override
        public List productList() {
            productRepository.add();
            return null;
        }

        @Override
        public void addProduct() {
            List list = productRepository.list().stream().filter(p -> p.equals("")).toList();
            if (list.size() > 0) {
                productRepository.update();
            } else {
                productRepository.add();
            }

        }

        @Override
        public void editProduct() {

        }

        @Override
        public void removeProduct() {

        }
    }
}
