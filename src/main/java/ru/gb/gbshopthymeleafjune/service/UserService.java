package ru.gb.gbshopthymeleafjune.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import ru.gb.gbapimay.user.api.UserGateway;
import ru.gb.gbapimay.user.dto.UserDto;
import ru.gb.gbshopthymeleafjune.entity.User;
import ru.gb.gbshopthymeleafjune.mapper.UserMapper;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserGateway userGateway; //FIXME BeanCreationException Не могу исправить

    private UserMapper userMapper;

    public void postUser (User user) {
        userGateway.handlePost(userMapper.toUserDto(user));
    }

    public UserDto findUserById (Long id) {
       return userGateway.getUser(id).getBody();
    }
}
