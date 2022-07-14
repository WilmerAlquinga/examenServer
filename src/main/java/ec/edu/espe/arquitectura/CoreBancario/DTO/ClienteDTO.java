package ec.edu.espe.arquitectura.CoreBancario.DTO;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

  private String cedula;

  private String nombreCompleto;

  private String estado;
}
