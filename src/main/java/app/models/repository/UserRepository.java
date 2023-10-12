package app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import app.models.entities.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByEmail(String email);
}