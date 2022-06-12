package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbshopthymeleafjune.entity.Category;
import ru.gb.gbshopthymeleafjune.service.CategoryService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("category", categoryService.getCategoryList());
        return "categoryList";
    }
    @GetMapping
    public String showForm (Model model, @RequestParam(name = "categoryId", required = false) Long id) {
        categoryService.showForm(id);
        return "categoryForm";
    }
    @PostMapping
    public String handlePost(Category category) {
        categoryService.handlePost(category);
        return "redirect: /api/v1/category";
    }
    @DeleteMapping("/delete/{categoryId}")
    public String deleteById(@PathVariable("categoryId") Long id) {
        categoryService.deleteById(id);
        return "redirect: /api/v1/category";
    }
}
