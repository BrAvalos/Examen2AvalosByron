package ec.edu.espe.examen2.controller.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data 
@Builder
public class EmpleadoPagoRQ {
    private String numeroCuenta;
    private BigDecimal valor;
    private String estado;
}
