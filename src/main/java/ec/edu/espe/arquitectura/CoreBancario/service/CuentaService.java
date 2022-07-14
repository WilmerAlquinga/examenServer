package ec.edu.espe.arquitectura.CoreBancario.service;

import ec.edu.espe.arquitectura.CoreBancario.dao.CuentaRepository;
import ec.edu.espe.arquitectura.CoreBancario.model.Cuenta;
import ec.edu.espe.arquitectura.CoreBancario.model.Transaccion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;


}
