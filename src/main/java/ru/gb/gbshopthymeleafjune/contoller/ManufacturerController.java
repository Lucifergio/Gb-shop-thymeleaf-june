package ru.gb.gbshopthymeleafjune.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;
import ru.gb.gbshopthymeleafjune.entity.Manufacturer;
import ru.gb.gbshopthymeleafjune.service.ManufacturerService;


@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping("/all")
    public String getProductList(Model model) {
        model.addAttribute("products", manufacturerService.getManufacturerList());
        return "manufacturerList";
    }

    @GetMapping
    public String showForm (Model model, @RequestParam(name = "manufacturerId", required = false) Long id) {
        model.addAttribute("product", manufacturerService.getManufacturer(id));
        return "manufacturerForm";
    }

    @PostMapping
    public String handlePost(Manufacturer manufacturer) {
        manufacturerService.handlePost(manufacturer);
        return "redirect:/api/v1/manufacturer/all";
    }

//    @GetMapping("/{manufacturerId}")
//    public String showInfo (Model model, @PathVariable("manufacturerId") Long id) {
//        model.addAttribute("product", manufacturerService.);
//        return "manufacturerForm";
//    }

    @DeleteMapping("/delete/{manufacturerId}")
    public String deleteById(@PathVariable("manufacturerId") Long id) {
        manufacturerService.deleteById(id);
        return "redirect:/api/v1/manufacturer/all";
    }
}
