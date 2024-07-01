package fj.utopis.property_service.mapper;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import fj.utopis.property_service.entities.Property;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyMapperImpl implements PropertyMapper{
    @Override
    public Property mapToProperty(PropertyRequest request) {
        return Property.builder()
                .name(request.name())
                .description(request.description())
                .country(request.country())
                .address(null)
                .propertyType(request.propertyType())
                .availability(request.availability())
                .numberOfRooms(request.numberOfRooms())
                .numberOfBathrooms(request.numberOfBathrooms())
                .price(request.price())
                .build();
    }

    @Override
    public PropertyResponse mapToPropertyResponse(Property property) {
        return new PropertyResponse(
                property.getId(),
                property.getName(),
                property.getDescription(),
                property.getAddress(),
                property.getCountry(),
                property.getPrice(),
                property.getNumberOfRooms(),
                property.getNumberOfBathrooms(),
                property.getPropertyType(),
                property.getAvailability(),
                property.getRating(),
                property.getCreatedDate(),
                property.getReviews()
        );
    }
}
