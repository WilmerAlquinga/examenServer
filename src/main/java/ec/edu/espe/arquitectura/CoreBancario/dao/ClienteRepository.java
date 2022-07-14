package ec.edu.espe.arquitectura.CoreBancario.dao;

import ec.edu.espe.arquitectura.CoreBancario.model.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
  Cliente findByCedula(String cedula);
}
