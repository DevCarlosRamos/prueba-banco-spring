package app.services;

import app.models.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> registerUser(User user);
    Mono<String> loginUser(String email, String password,String token);
    Mono<User> updateUser(String userId, User user);
    Mono<Void> deleteUser(String userId);
    Flux<User> getAllUsers();
}