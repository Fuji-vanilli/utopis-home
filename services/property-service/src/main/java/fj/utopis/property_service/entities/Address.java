package fj.utopis.property_service.entities;


import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String province;
    private String postalCode;
}
