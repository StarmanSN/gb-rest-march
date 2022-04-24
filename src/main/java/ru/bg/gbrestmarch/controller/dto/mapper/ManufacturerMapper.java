package ru.bg.gbrestmarch.controller.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.bg.gbrestmarch.controller.dto.ManufacturerDto;
import ru.bg.gbrestmarch.entity.Manufacturer;

@Mapper(uses = ManufacturerMapper.class)
public interface ManufacturerMapper {

    @Mapping(source = "manufacturerId", target = "id")
    Manufacturer toManufacturer(ManufacturerDto manufacturerDto);

    @Mapping(source = "id", target = "manufacturerId")
    ManufacturerDto toManufacturerDto(Manufacturer manufacturer);
}
