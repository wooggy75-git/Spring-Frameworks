package com.sparta.weak04.service;

import com.sparta.weak04.models.ItemDto;
import com.sparta.weak04.models.Product;
import com.sparta.weak04.models.ProductMypriceRequestDto;
import com.sparta.weak04.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service // 서비스임을 선언합니다.
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(productMypriceRequestDto);
        return product.getId();
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return product.getId();
    }
}
