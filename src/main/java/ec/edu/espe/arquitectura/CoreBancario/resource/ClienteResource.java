package ec.edu.espe.arquitectura.CoreBancario.resource;

import ec.edu.espe.arquitectura.CoreBancario.mapper.ClienteMapper;
import ec.edu.espe.arquitectura.CoreBancario.model.Cliente;
import ec.edu.espe.arquitectura.CoreBancario.DTO.ClienteDTO;
import ec.edu.espe.arquitectura.CoreBancario.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteResource {
    private final ClienteService clienteService;

    @GetMapping(path = "/{nombreCompleto}")
    public ResponseEntity<ClienteDTO> getByNombreCompleto(@PathVariable("nombreCompleto") String nombreCompleto) {
        try {
            Cliente cliente = this.clienteService.obtainByNombreCompleto(nombreCompleto);
            return ResponseEntity.ok(ClienteMapper.buildClienteDTO(cliente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
