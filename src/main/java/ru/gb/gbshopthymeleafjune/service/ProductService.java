package ru.gb.gbshopthymeleafjune.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.category.api.CategoryGateway;
import ru.gb.gbapimay.common.enums.Status;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;
import ru.gb.gbapimay.product.api.ProductGateway;
import ru.gb.gbapimay.product.dto.ProductDto;
import ru.gb.gbshopthymeleafjune.entity.Product;
import ru.gb.gbshopthymeleafjune.mapper.ProductMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductGateway productGateway;
    private final ManufacturerGateway manufacturerGateway;
    private final CategoryGateway categoryGateway;
    private ProductMapper productMapper;

    public List<ProductDto> getProductList() {
        return productGateway.getProductList();
    }

    public Product getProductById (Long id)  {
       return productMapper.toProduct(productGateway.getProduct(id).getBody());
    }
    public ProductDto showForm(Long id) {
        return productGateway.getProduct(id).getBody();
    }

    public void handlePost(Product product) {
        productGateway.handlePost(productMapper.toProductDto(product));
    }

    public void deleteById(Long id) {
        productGateway.deleteById(id);
    }
}
