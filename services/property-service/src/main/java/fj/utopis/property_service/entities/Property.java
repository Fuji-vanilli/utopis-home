package fj.utopis.property_service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "property")
public class Property {
    @Id
    private String id;
    private String name;
    private String description;
    private PropertyType propertyType;
    private Address address;
    private BigDecimal price;
    private BigDecimal numberOfRooms;
    private BigDecimal numberOfBathrooms;
    private List<String> images;
    private BigDecimal rating;
    private List<String> reviews= new ArrayList<>();
    private Date availability;
    private Instant createdDate;
}
