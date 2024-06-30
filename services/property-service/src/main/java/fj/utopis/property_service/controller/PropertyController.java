package fj.utopis.property_service.controller;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyController {
    @PostMapping("create")
    ResponseEntity<PropertyResponse> createProperty(@RequestBody PropertyRequest propertyRequest);
    @GetMapping("all")
    ResponseEntity<List<PropertyResponse>> findAll();
}
