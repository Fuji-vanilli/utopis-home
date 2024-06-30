package fj.utopis.property_service.mapper;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import fj.utopis.property_service.entities.Property;

public interface PropertyMapper {
    Property mapToProperty(PropertyRequest request);
    PropertyResponse mapToPropertyResponse(Property property);
}
