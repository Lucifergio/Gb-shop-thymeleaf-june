package ru.gb.gbshopthymeleafjune.entity;

import lombok.Data;
import ru.gb.gbapimay.category.dto.CategoryDto;
import ru.gb.gbapimay.common.enums.Status;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class Product {

    private Long id;
    private String title;
    private BigDecimal cost;
    private LocalDate manufactureDate;
    private Status status;
    private String manufacturer;
    private Set<CategoryDto> categories;
}
