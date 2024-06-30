package fj.utopis.property_service.services;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import fj.utopis.property_service.mapper.PropertyMapper;
import fj.utopis.property_service.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{
    private final PropertyRepository repository;
    private final PropertyMapper mapper;

    @Override
    public PropertyResponse create(PropertyRequest request) {


        return null;
    }

    @Override
    public List<PropertyResponse> findAll() {
        return null;
    }
}
