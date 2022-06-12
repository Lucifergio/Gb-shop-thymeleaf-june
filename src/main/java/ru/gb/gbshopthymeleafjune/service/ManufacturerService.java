package ru.gb.gbshopthymeleafjune.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.gbapimay.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapimay.manufacturer.dto.ManufacturerDto;
import ru.gb.gbshopthymeleafjune.entity.Manufacturer;
import ru.gb.gbshopthymeleafjune.mapper.ManufacturerMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ManufacturerService {

    private final ManufacturerGateway manufacturerGateway;
    private ManufacturerMapper manufacturerMapper;

    public List<ManufacturerDto> getManufacturerList() {
        return manufacturerGateway.getManufacturerList();
    }
    public ManufacturerDto getManufacturer(Long id) {
        return manufacturerGateway.getManufacturer(id).getBody();
    }

    public ManufacturerDto showForm (Long id) {
        return manufacturerGateway.getManufacturer(id).getBody();
    }

    public void handlePost(Manufacturer manufacturer) {
        manufacturerGateway.handlePost(manufacturerMapper.toManufacturerDto(manufacturer));
    }

//    public String showInfo (Long id) {
//        model.addAttribute("product", manufacturerGateway.getManufacturer(id).getBody());
//        return "manufacturerForm";
//    }

    public void deleteById(Long id) {
        manufacturerGateway.deleteById(id);
    }
}
