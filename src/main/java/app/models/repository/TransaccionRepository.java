package app.models.repository;

import app.models.entities.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String>{

	
}
