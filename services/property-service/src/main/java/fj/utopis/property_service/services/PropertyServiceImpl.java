package fj.utopis.property_service.services;

import fj.utopis.property_service.DTO.PropertyRequest;
import fj.utopis.property_service.DTO.PropertyResponse;
import fj.utopis.property_service.entities.Property;
import fj.utopis.property_service.mapper.PropertyMapper;
import fj.utopis.property_service.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService{
    private final PropertyRepository repository;
    private final PropertyMapper mapper;

    @Override
    public PropertyResponse create(PropertyRequest request) {
        if (repository.existsByName(request.name())) {
            log.error("property already exist into the database");
            throw new UnsupportedOperationException("property already exist into the database");
        }

        Property property = mapper.mapToProperty(request);

        property.setId(UUID.randomUUID().toString());
        property.setCreatedDate(Instant.now());

        log.info("new property created");
        repository.save(property);

        return mapper.mapToPropertyResponse(property);
    }

    @Override
    public List<PropertyResponse> findAll() {
        log.info("all properties getted successfully!");
        return repository.findAll().stream()
                .map(mapper::mapToPropertyResponse)
                .toList();
    }
}
