package app.models.repository;

import app.models.entities.Transaccion;
import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String>{

	Flux<Transaccion> findByEmisorId(String emisorId);
}
