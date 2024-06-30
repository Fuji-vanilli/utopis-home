package fj.utopis.property_service.repository;

import fj.utopis.property_service.entities.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PropertyRepository extends MongoRepository<Property, String> {
}
