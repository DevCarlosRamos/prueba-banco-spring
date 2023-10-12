package app.services;

import app.models.entities.Transaccion;
import reactor.core.publisher.Mono;

public interface TransaccionService {

	Mono<String> cambiarDinero(Transaccion transaccion);
}
