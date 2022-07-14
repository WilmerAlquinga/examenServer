package ec.edu.espe.arquitectura.CoreBancario.dao;

import ec.edu.espe.arquitectura.CoreBancario.model.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransaccionRepository extends MongoRepository<Transaccion, String> {
}
