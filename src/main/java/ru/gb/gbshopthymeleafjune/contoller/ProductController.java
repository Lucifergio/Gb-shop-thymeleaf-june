package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.category.api.CategoryGateway;
import ru.gb.gbapimay.common.enums.Status;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;
import ru.gb.gbapimay.product.api.ProductGateway;
import ru.gb.gbapimay.product.dto.ProductDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductGateway productGateway;
    private final ManufacturerGateway manufacturerGateway;
    private final CategoryGateway categoryGateway;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productGateway.getProductList());
        return "productList";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "productId", required = false) Long id) {
        List<ManufacturerDto> list = new ArrayList<>();
        list.addAll(manufacturerGateway.getManufacturerList());
        model.addAttribute("product", ProductDto.builder()
                .id(1L)
                .manufacturer("")
                .categories(new HashSet<>())
                .cost(BigDecimal.valueOf(100))
                .status(Status.ACTIVE)
                .build());
        model.addAttribute("manufacturer",  list);
        model.addAttribute("category", categoryGateway.getCategoryList());
        return "productForm";
    }

    @PostMapping
    public String handlePost(ProductDto productDto) {
        productGateway.handlePost(productDto);
        return "redirect: /api/v1/product";
    }


    @DeleteMapping("/delete/{productId}")
    public String deleteById(@PathVariable("productId") Long id) {
        productGateway.deleteById(id);
        return "redirect: /api/v1/product";
    }
}
