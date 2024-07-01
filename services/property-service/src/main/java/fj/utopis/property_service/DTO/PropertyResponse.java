package fj.utopis.property_service.DTO;

import fj.utopis.property_service.entities.Address;
import fj.utopis.property_service.entities.PropertyType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public record PropertyResponse(
        String id,
        String name,
        String description,
        Address address,
        String country,
        BigDecimal price,
        BigDecimal numberOfRooms,
        BigDecimal numberOfBathrooms,
        PropertyType propertyType,
        Date availability,
        BigDecimal rating,
        Instant createdAt,
        List<String> reviews
) {
}
