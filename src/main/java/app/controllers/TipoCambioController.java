package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.models.entities.TipoCambio;
import app.services.TipoCambioService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
    private final TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @GetMapping
    public Flux<TipoCambio> getAllTipoCambio() {
        return tipoCambioService.getAllTipoCambio();
    }

    @PostMapping
    public Mono<TipoCambio> createTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.createTipoCambio(tipoCambio);
    }

    @PutMapping("/{id}")
    public Mono<TipoCambio> updateTipoCambio(@PathVariable String id, @RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.updateTipoCambio(id, tipoCambio);
    }

    @GetMapping("/{id}")
    public Mono<TipoCambio> getTipoCambioById(@PathVariable String id) {
        return tipoCambioService.getTipoCambioById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTipoCambio(@PathVariable String id) {
        return tipoCambioService.deleteTipoCambio(id);
    }
}