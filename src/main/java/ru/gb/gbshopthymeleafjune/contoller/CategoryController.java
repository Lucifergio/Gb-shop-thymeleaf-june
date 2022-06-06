package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.category.api.CategoryGateway;
import ru.gb.gbapimay.category.dto.CategoryDto;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryGateway categoryGateway;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("category", categoryGateway.getCategoryList());
        return "categoryList";
    }

    @GetMapping
    public String showForm (Model model, @RequestParam(name = "categoryId", required = false) Long id) {
        model.addAttribute("category", categoryGateway.getCategory(id));
        return "categoryForm";
    }

    @PostMapping
    public String handlePost(CategoryDto categoryDto) {
        categoryGateway.handlePost(categoryDto);
        return "redirect: /api/v1/category";
    }


    @DeleteMapping("/delete/{categoryId}")
    public String deleteById(@PathVariable("categoryId") Long id) {
        categoryGateway.deleteById(id);
        return "redirect: /api/v1/category";
    }
}
