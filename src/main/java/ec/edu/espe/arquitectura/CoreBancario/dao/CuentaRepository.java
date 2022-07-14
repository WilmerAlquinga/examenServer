package ec.edu.espe.arquitectura.CoreBancario.dao;

import ec.edu.espe.arquitectura.CoreBancario.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
    Cuenta findByCodigoInterno (Integer cod);
}
