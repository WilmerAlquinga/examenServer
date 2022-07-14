package ec.edu.espe.arquitectura.CoreBancario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Document(collection = "cuentas")
@TypeAlias("cuentas")
public class Cuenta {

    @Id
    private String id;

    @Indexed(name = "idx_cuenta_idCliente", unique = true)
    private String idCliente;

    private Integer codigoInterno;

    private BigDecimal saldo;

    private Date fechaUltimoMovimiento;

    private String estado;
}
