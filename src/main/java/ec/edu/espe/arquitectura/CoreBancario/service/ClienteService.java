package ec.edu.espe.arquitectura.CoreBancario.service;

import ec.edu.espe.arquitectura.CoreBancario.dao.ClienteRepository;
import ec.edu.espe.arquitectura.CoreBancario.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.CoreBancario.model.Cliente;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public Cliente obtainByNombreCompleto(String nombre) {
    Cliente clienteOpt = this.clienteRepository.findByNombreCompleto(nombre);
    if (clienteOpt == null) {
      throw new EntityNotFoundException("Don't exists User by Nombre Completo");
    }

    return clienteOpt;
  }
}
