package ec.edu.espe.arquitectura.CoreBancario.service;

import ec.edu.espe.arquitectura.CoreBancario.dao.ClienteRepository;
import ec.edu.espe.arquitectura.CoreBancario.dao.CuentaRepository;
import ec.edu.espe.arquitectura.CoreBancario.dao.TransaccionRepository;
import ec.edu.espe.arquitectura.CoreBancario.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.CoreBancario.model.Cliente;
import ec.edu.espe.arquitectura.CoreBancario.model.Cuenta;
import ec.edu.espe.arquitectura.CoreBancario.model.Transaccion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;

    public Transaccion transferir(Transaccion transaccion) {
        if(validarCliente(transaccion.getCuentaDestino()) && validarCliente(transaccion.getCuentaOrigen())) {
            cambiarValor("Destino", transaccion.getValor(), transaccion.getCuentaDestino());
            cambiarValor("Origen", transaccion.getValor(), transaccion.getCuentaOrigen());
        }
    }

    public void cambiarValor(String tipo, BigDecimal valor, Integer internalId) {
        if(tipo.equals("Destino")) {
            Cuenta cuenta = this.cuentaRepository.findByCodigoInterno(internalId);
            cuenta.setSaldo(cuenta.getSaldo() + valor);
        } else {
            Cuenta cuenta = this.cuentaRepository.findByCodigoInterno(internalId);
            cuenta.setSaldo(cuenta.getSaldo() - valor);
        }
    }

    public Boolean validarCliente(Integer codigoInterno) {
        Cuenta cuenta = this.cuentaRepository.findByCodigoInterno(codigoInterno);
        if(cuenta != null) {
            Cliente cliente = this.clienteRepository.findByCedula(cuenta.getIdCliente());
            if(cliente.getEstado().equals("Activo")){
                return true;
            } else {
                throw new EntityNotFoundException("No se encontró el cliente");
            }
        } else {
            throw new EntityNotFoundException("No se encontró la cuenta");
        }
    }
}
