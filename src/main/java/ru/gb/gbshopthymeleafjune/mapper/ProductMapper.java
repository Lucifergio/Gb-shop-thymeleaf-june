package ru.gb.gbshopthymeleafjune.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.gb.gbapimay.category.api.CategoryGateway;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.product.dto.ProductDto;
import ru.gb.gbshopthymeleafjune.entity.Product;
@Mapper(uses = ManufacturerMapper.class)
public interface ProductMapper {

    Product toProduct(ProductDto productDto, @Context ManufacturerGateway manufacturerGateway, @Context CategoryGateway categoryGateway);

    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto body);

//    default Manufacturer getManufacturer(String manufacturer, @Context ManufacturerGateway manufacturerGateway) {
//        return manufacturerGateway.(manufacturer).orElseThrow(
//                () -> new NoSuchElementException("There isn't manufacturer with name " + manufacturer)
//        );
//    }
//
//    default String getManufacturer(Manufacturer manufacturer) {
//        return manufacturer.getName();
//    }
//
//    default Set<Category> categoryDtoSetToCategorySet(Set<CategoryDto> categories, @Context CategoryDao categoryDao) {
//        return categories.stream().map(c -> categoryDao.findById(c.getId())
//                .orElseThrow(
//                        () -> new NoSuchElementException("There isn't category with id: " + c.getId())
//                ))
//                .collect(Collectors.toSet());
//    }
}
