package ec.edu.espe.examen2.controller.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class PagoRolRQ {
    private String mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private BigDecimal valorReal;
    private BigDecimal valorTotal;

    private List<EmpleadoPagoRQ> empleadoPago;
    
}
