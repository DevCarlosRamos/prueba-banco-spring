package app.services;

import app.models.entities.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {

	Mono<String> cambiarDinero(Transaccion transaccion);
    public Flux<Transaccion> getTransaccionesPorEmisor(String emisorId);
}
