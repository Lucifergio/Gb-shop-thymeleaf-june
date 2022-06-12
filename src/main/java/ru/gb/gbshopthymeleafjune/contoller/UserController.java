package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.user.dto.UserDto;
import ru.gb.gbshopthymeleafjune.entity.User;
import ru.gb.gbshopthymeleafjune.service.UserService;

@RequiredArgsConstructor
@Controller
@ComponentScan
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public String showForm (Model model, @RequestParam(name = "id", required = false) Long id) {
        UserDto user;

        if (id != null) {
            user =  userService.findUserById(id);
        } else {
            user = UserDto.builder().build();
        }
        model.addAttribute("userDto", user);
        return "registerForm";
    }

    @PostMapping
    public String handlePost(User userDto) {
        userService.postUser(userDto);
        return "redirect: /api/v1/product/all";
    }
}
