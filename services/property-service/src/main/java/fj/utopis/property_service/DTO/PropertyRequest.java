package fj.utopis.property_service.DTO;

import fj.utopis.property_service.entities.Address;
import fj.utopis.property_service.entities.PropertyType;

import java.math.BigDecimal;
import java.util.Date;

public record PropertyRequest(
        String name,
        String description,
        Address address,
        BigDecimal price,
        BigDecimal numberOfRooms,
        BigDecimal numberOfBathrooms,
        PropertyType propertyType,
        Date availability
) {
}
