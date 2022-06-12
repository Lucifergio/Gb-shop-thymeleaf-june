package ru.gb.gbshopthymeleafjune.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.category.api.CategoryGateway;
import ru.gb.gbapimay.category.dto.CategoryDto;
import ru.gb.gbshopthymeleafjune.entity.Category;
import ru.gb.gbshopthymeleafjune.mapper.CategoryMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryGateway categoryGateway;
    private CategoryMapper categoryMapper;

    public List<CategoryDto> getCategoryList() {
        return categoryGateway.getCategoryList();
    }

    public CategoryDto showForm (Long id) {
        return categoryGateway.getCategory(id).getBody();
    }

    public void handlePost(Category category) {
        categoryGateway.handlePost(categoryMapper.toCategoryDto(category));
    }

    public void deleteById(Long id) {
        categoryGateway.deleteById(id);
    }
}
