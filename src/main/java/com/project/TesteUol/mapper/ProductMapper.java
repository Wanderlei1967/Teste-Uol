package com.project.TesteUol.mapper;

import com.project.TesteUol.model.Product;
import com.project.TesteUol.model.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public
    Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        return product;
    }

    public
    ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());

        return dto;

    }

    public List<ProductDto>toDto(List<Product> listProduct) {
        return listProduct.stream().map(this::toDto).collect(Collectors.toList());
    }

}
