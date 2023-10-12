package app.models.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import app.models.entities.TipoCambio;

public interface TipoCambioRepository extends ReactiveMongoRepository<TipoCambio, String> {
}