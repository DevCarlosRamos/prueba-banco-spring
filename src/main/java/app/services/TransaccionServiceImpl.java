package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.entities.TipoCambio;
import app.models.entities.Transaccion;
import app.models.entities.User;
import app.models.repository.TipoCambioRepository;
import app.models.repository.TransaccionRepository;
import app.models.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class TransaccionServiceImpl implements TransaccionService{
	
	private final TipoCambioRepository tipoCambioRepository;
	private final UserRepository userRepository;
	private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionServiceImpl(
    		TipoCambioRepository tipoCambioRepository, 
    		UserRepository userRepository, 
    		TransaccionRepository transaccionRepository) 
    {
        this.tipoCambioRepository = tipoCambioRepository;
        this.userRepository = userRepository;
        this.transaccionRepository = transaccionRepository;
    }
    
	@Override
	public Mono<String> cambiarDinero(Transaccion transaccion) {
	    return userRepository.findById(transaccion.getEmisorId())
	        .switchIfEmpty(Mono.error(new RuntimeException("Usuario emisor no encontrado")))
	        .flatMap(userEmisor -> {
	            return userRepository.findById(transaccion.getReceptorId())
	                .switchIfEmpty(Mono.error(new RuntimeException("Usuario receptor no encontrado")))
	                .flatMap(userReceptor -> {
	                    return tipoCambioRepository.findById(transaccion.getTipoCambio())
	                        .switchIfEmpty(Mono.error(new RuntimeException("Tipo de cambio no encontrado")))
	                        .flatMap(tipoCambio -> {
	                            double montoOrigen = transaccion.getMonto();
	                            double montoDestino = montoOrigen * tipoCambio.getTipoCambio();

	                            if (userEmisor.getFondo() < montoOrigen) {
	                                return Mono.error(new RuntimeException("Fondos insuficientes en la cuenta del emisor"));
	                            }

	                            userEmisor.setFondo(userEmisor.getFondo() - montoOrigen);
	                            userEmisor.setTransaccion(transaccion);
	                            userReceptor.setFondo(userReceptor.getFondo() + montoDestino);
	                            userReceptor.setTransaccion(transaccion);

	                            // Actualizar usuarios
	                            Mono<Void> updateEmisorMono = userRepository.save(userEmisor).then();
	                            Mono<Void> updateReceptorMono = userRepository.save(userReceptor).then();

	                            // Guardar la transacción
	                            Mono<Void> saveTransaccionMono = transaccionRepository.save(transaccion).then();

	                            return Mono.when(updateEmisorMono, updateReceptorMono, saveTransaccionMono)
	                                .thenReturn("Transacción realizada con éxito");
	                        });
	                });
	        });
	}


}
