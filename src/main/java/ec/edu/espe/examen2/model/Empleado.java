package ec.edu.espe.examen2.model;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class Empleado {
    private String cedulaIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroCuenta;
}
