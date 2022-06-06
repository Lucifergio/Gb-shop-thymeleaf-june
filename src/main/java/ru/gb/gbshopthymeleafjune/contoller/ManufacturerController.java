package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;


@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {

    private final ManufacturerGateway manufacturerGateway;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", manufacturerGateway.getManufacturerList());
        return "manufacturerList";
    }

    @GetMapping
    public String showForm (Model model, @RequestParam(name = "manufacturerId", required = false) Long id) {
        model.addAttribute("product", manufacturerGateway.getManufacturer(id).getBody());
        return "manufacturerForm";
    }

    @PutMapping
    public String handlePost(ManufacturerDto manufacturerDto, @RequestParam(name = "id", required = false) Long id) {
        manufacturerGateway.handleUpdate(id, manufacturerDto);
        return "redirect:/api/v1/manufacturer/all";
    }

    @GetMapping("/{manufacturerId}")
    public String showInfo (Model model, @PathVariable("manufacturerId") Long id) {
        model.addAttribute("product", manufacturerGateway.getManufacturer(id).getBody());
        return "manufacturerForm";
    }

    @DeleteMapping("/delete/{manufacturerId}")
    public String deleteById(@PathVariable("manufacturerId") Long id) {
        manufacturerGateway.deleteById(id);
        return "redirect:/api/v1/manufacturer/all";
    }
}
