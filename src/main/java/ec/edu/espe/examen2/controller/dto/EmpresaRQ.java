package ec.edu.espe.examen2.controller.dto;

import java.util.List;


import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private String cuentaPrincipal;
    private List<EmpleadoRQ> empleado;
}
