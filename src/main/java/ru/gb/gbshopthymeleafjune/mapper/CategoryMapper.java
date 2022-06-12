package ru.gb.gbshopthymeleafjune.mapper;

import org.mapstruct.Mapper;
import ru.gb.gbapimay.category.dto.CategoryDto;
import ru.gb.gbshopthymeleafjune.entity.Category;

@Mapper
public interface CategoryMapper {
    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);
}
