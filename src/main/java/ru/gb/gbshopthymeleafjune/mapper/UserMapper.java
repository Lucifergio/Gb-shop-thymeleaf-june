package ru.gb.gbshopthymeleafjune.mapper;

import org.mapstruct.Mapper;
import ru.gb.gbapimay.category.dto.CategoryDto;
import ru.gb.gbapimay.user.dto.UserDto;
import ru.gb.gbshopthymeleafjune.entity.Category;
import ru.gb.gbshopthymeleafjune.entity.User;

@Mapper
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);
}
