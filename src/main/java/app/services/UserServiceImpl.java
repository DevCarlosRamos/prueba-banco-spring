package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.entities.User;
import app.models.repository.UserRepository;
import app.util.JwtUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    //private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        //this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<User> registerUser(User user) {
        return userRepository.findByEmail(user.getEmail())
                .flatMap(existingUser -> Mono.error(new RuntimeException("Email already exists")))
                .switchIfEmpty(userRepository.save(new User(
                		user.getEmail(),
                		user.getNombre(), 
                		user.getPassword(),
                		user.getFondoSOL(),
                		user.getFondoUSD())))
        		.cast(User.class);
    }

    @Override
    public Mono<String> loginUser(String email, String password,String token) {
        return userRepository.findByEmail(email)
                .flatMap(user -> {
                    if (password.equalsIgnoreCase(user.getPassword()) || 
                    		token.equalsIgnoreCase(user.getToken())) {
                        String userId = user.getId();
                        //String token = jwtUtil.generateToken(userId);
                        user.setToken(userId);
                        userRepository.save(user);
                        
                        return Mono.just(userId);
                    } else {
                        return Mono.error(new RuntimeException("Invalid credentials"));
                    }
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    @Override
    public Mono<User> updateUser(String userId, User user) {
        return userRepository.findById(userId)
                .flatMap(existingUser -> {
                    existingUser.setNombre(user.getNombre());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setFondoSOL(user.getFondoSOL());
                    existingUser.setFondoUSD(user.getFondoUSD());
                    return userRepository.save(existingUser);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")));
    }

    @Override
    public Mono<Void> deleteUser(String userId) {
        return userRepository.findById(userId)
                .flatMap(user -> userRepository.delete(user))
                .then();
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

}