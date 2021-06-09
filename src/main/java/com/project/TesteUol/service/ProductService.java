package com.project.TesteUol.service;

import com.project.TesteUol.exceptions.BusinessExceptions;
import com.project.TesteUol.exceptions.NotFoundExceptiom;
import com.project.TesteUol.mapper.ProductMapper;
import com.project.TesteUol.model.Product;
import com.project.TesteUol.model.dto.ProductDto;
import com.project.TesteUol.repository.ProductRepository;
import com.project.TesteUol.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    @Transactional
    public ProductDto save(ProductDto dto) {

        Optional<Product> optionalProduct = repository.findById(dto.getName());

        if(optionalProduct.isPresent()){
            throw new BusinessExceptions(MessageUtils.PRODUC_ALEADY_EXISTS);
        }

        Product product = mapper.toEntity(dto);
        repository.save(product);
        return mapper.toDto(product);
    }
    @Transactional
    public ProductDto update(ProductDto dto) {
        Optional<Product> optionalProduct = repository.findByProductUpdate(dto.getName());
        if(optionalProduct.isPresent()){
            throw new BusinessExceptions(MessageUtils.PRODUC_ALEADY_EXISTS);
        }

        Product product = mapper.toEntity(dto);
        repository.save(product);
        return mapper.toDto(product);
    }
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(String id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundExceptiom::new);

    }

    @Transactional
    public ProductDto delete(String id) {
        ProductDto dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

   @Transactional(readOnly = true)
   public List<ProductDto>findByFilter() {
      return repository.findByFilter().map(mapper::toDto).orElseThrow(NotFoundExceptiom::new);
   }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }
}
