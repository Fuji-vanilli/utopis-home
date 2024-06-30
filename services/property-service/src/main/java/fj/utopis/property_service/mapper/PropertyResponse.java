package fj.utopis.property_service.mapper;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.entities.Property;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyResponse implements PropertyMapper{
    @Override
    public Property mapToProperty(PropertyRequest request) {
        return Property.builder()
                .name(request.name())
                .description(request.description())
                .address(request.address())
                .propertyType(request.propertyType())
                .availability(request.availability())
                .numberOfRooms(request.numberOfRooms())
                .numberOfBathrooms(request.numberOfBathrooms())
                .price(request.price())
                .build();
    }

    @Override
    public fj.utopis.property_service.DTO.PropertyResponse mapToPropertyResponse(Property property) {
        return null;
    }
}
