package com.sparta.weak04.controller;

import com.sparta.weak04.models.Product;
import com.sparta.weak04.models.ProductMypriceRequestDto;
import com.sparta.weak04.models.ProductRepository;
import com.sparta.weak04.models.ProductRequestDto;
import com.sparta.weak04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductService productService;
    private final ProductRepository productRepository;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        System.out.println("[khw] getProducts");
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        System.out.println("[khw] createProduct");
        Product product = new Product(productRequestDto);
        productRepository.save(product);
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateMyprice(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto) {
        System.out.println("[khw] updateMyprice");
        return productService.update(id, productMypriceRequestDto);
    }
}