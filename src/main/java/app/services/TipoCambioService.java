package app.services;

import app.models.entities.TipoCambio;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TipoCambioService {
    Flux<TipoCambio> getAllTipoCambio();
    Mono<TipoCambio> createTipoCambio(TipoCambio tipoCambio);
    Mono<TipoCambio> updateTipoCambio(String id, TipoCambio tipoCambio);
    Mono<TipoCambio> getTipoCambioById(String id);
    Mono<Void> deleteTipoCambio(String id);
}