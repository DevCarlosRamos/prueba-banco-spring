package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.models.entities.Transaccion;
import app.services.TransaccionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaccion")
public class TransaccionController {

    private final TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @PostMapping("/hacer-cambio")
    public Mono<String> realizarTransaccion(@RequestBody Transaccion transaccion) {
        return transaccionService.cambiarDinero(transaccion);
    }
    
    @GetMapping("/{emisorId}")
    public Flux<Transaccion> getTransaccionesPorEmisor(@PathVariable String emisorId) {
        return transaccionService.getTransaccionesPorEmisor(emisorId);
    }
}
