package fj.utopis.property_service.controller;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import fj.utopis.property_service.services.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static fj.utopis.property_service.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class PropertyApi implements PropertyController{
    private final PropertyService propertyService;
    @Override
    public ResponseEntity<PropertyResponse> createProperty(PropertyRequest request) {
        return ResponseEntity.ok(propertyService.create(request));
    }

    @Override
    public ResponseEntity<List<PropertyResponse>> findAll() {
        return ResponseEntity.ok(propertyService.findAll());
    }
}
