package fj.utopis.property_service.services;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;

import java.util.List;

public interface PropertyService {
    PropertyResponse create(PropertyRequest request);
    List<PropertyResponse> findAll();
}
