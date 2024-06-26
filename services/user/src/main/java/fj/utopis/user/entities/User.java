package fj.utopis.user.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Document(value = "user")
public class User {
    @Id
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String imageUrl;
    private Subscription subscription= Subscription.FREE;
    private Instant createdDate;
    private Instant lastModifiedDate;
}
