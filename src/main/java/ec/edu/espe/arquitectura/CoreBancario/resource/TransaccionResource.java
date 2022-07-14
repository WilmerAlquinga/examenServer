package ec.edu.espe.arquitectura.CoreBancario.resource;

import ec.edu.espe.arquitectura.CoreBancario.model.Transaccion;
import ec.edu.espe.arquitectura.CoreBancario.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transacciones")
@RequiredArgsConstructor
public class TransaccionResource {

    private final TransaccionService service;

    @PostMapping
    public ResponseEntity<Transaccion> transferir(@RequestBody Transaccion transaccion) {
        try{
            service.transferir(transaccion);
            ResponseEntity.ok(service.crearTransaccion(transaccion));
        } catch (Exception e) {
            ResponseEntity.badRequest().build();
        }
    }

}
