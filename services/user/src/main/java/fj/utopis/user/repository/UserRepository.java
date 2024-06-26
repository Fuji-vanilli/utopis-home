package fj.utopis.user.repository;

import fj.utopis.user.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findOneByEmail(String email);
}

