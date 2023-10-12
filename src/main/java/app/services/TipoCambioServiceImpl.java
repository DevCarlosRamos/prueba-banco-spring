package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.entities.TipoCambio;
import app.models.repository.TipoCambioRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    private final TipoCambioRepository tipoCambioRepository;

    @Autowired
    public TipoCambioServiceImpl(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    @Override
    public Flux<TipoCambio> getAllTipoCambio() {
        return tipoCambioRepository.findAll();
    }

    @Override
    public Mono<TipoCambio> createTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.save(tipoCambio);
    }

    @Override
    public Mono<TipoCambio> updateTipoCambio(String id, TipoCambio tipoCambio) {
        return tipoCambioRepository.findById(id)
                .flatMap(existingTipoCambio -> {
                    existingTipoCambio.setMonedaOrigen(tipoCambio.getMonedaOrigen());
                    existingTipoCambio.setMonedaDestino(tipoCambio.getMonedaDestino());
                    existingTipoCambio.setTipoCambio(tipoCambio.getTipoCambio());
                    return tipoCambioRepository.save(existingTipoCambio);
                });
    }

    @Override
    public Mono<TipoCambio> getTipoCambioById(String id) {
        return tipoCambioRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteTipoCambio(String id) {
        return tipoCambioRepository.deleteById(id);
    }
}