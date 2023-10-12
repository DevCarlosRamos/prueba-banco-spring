package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.models.entities.User;
import app.services.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Mono<User> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public Mono<String> loginUser(@RequestBody User user) {
        return userService.loginUser(user.getEmail(), user.getPassword(), user.getToken());
    }
    
    @GetMapping("/users")
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/users/{userId}")
    public Mono<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/users/{userId}")
    public Mono<Void> deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
    
}