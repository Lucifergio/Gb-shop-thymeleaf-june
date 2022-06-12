package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbshopthymeleafjune.entity.Product;
import ru.gb.gbshopthymeleafjune.service.CategoryService;
import ru.gb.gbshopthymeleafjune.service.ManufacturerService;
import ru.gb.gbshopthymeleafjune.service.ProductService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final CategoryService categoryService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "productList";
    }

    @GetMapping
    public String showForm(Model model, @RequestParam(name = "productId", required = false) Long id) {
        Product product;
        if (id != null) {
            product = productService.getProductById(id);
        } else {
            product = new Product();
        }
        model.addAttribute("product", product);
        model.addAttribute("manufacturer",  manufacturerService.getManufacturerList());
        model.addAttribute("category", categoryService.getCategoryList());
        return "productForm";
    }

    @PostMapping
    public String handlePost(Product product) {
        productService.handlePost(product);
        return "redirect: /api/v1/product";
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
        return "redirect: /api/v1/product";
    }
}
