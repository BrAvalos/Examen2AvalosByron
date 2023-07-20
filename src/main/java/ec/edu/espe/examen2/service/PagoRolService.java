package ec.edu.espe.examen2.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.controller.dto.EmpleadoPagoRQ;
import ec.edu.espe.examen2.controller.dto.PagoRolRQ;
import ec.edu.espe.examen2.model.EmpleadoPago;
import ec.edu.espe.examen2.model.Empresa;
import ec.edu.espe.examen2.model.PagoRol;
import ec.edu.espe.examen2.repository.EmpresaRepository;
import ec.edu.espe.examen2.repository.PagoRolRepository;

@Service
public class PagoRolService {
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository,EmpresaRepository empresaRepository) {
        this.pagoRolRepository = pagoRolRepository;
        this.empresaRepository = empresaRepository;
    }

    public void createPagoRol(PagoRolRQ pagoRolRQ){
        if(this.existenPagosEnMes(pagoRolRQ.getMes())){
            PagoRol pagoRol = this.transform(pagoRolRQ);
            pagoRol.setValorTotal(BigDecimal.valueOf(0));
            BigDecimal valorTotal = calcularValorTotal(pagoRolRQ.getEmpleadoPago());
            pagoRol.setValorTotal(valorTotal);
            this.pagoRolRepository.save(pagoRol);
        }
        

    }

    private BigDecimal calcularValorTotal(List<EmpleadoPagoRQ> empleadosPago) {
        BigDecimal valorTotal = BigDecimal.ZERO;
    
        for (EmpleadoPagoRQ empleadoPago : empleadosPago) {
            valorTotal = valorTotal.add(empleadoPago.getValor());
        }
    
        return valorTotal;
    }

    private PagoRol transform(PagoRolRQ rq){
        return PagoRol.builder().mes(rq.getMes())
                .fechaProceso(rq.getFechaProceso())
                .rucEmpresa(rq.getRucEmpresa())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleado(transformEmpleadoPago(rq.getEmpleadoPago()))
                .build();
    }

    private List<EmpleadoPago> transformEmpleadoPago(List<EmpleadoPagoRQ> empleadoPagoRQList) {
        List<EmpleadoPago> empleadosPago = new ArrayList<>();
    
        for (EmpleadoPagoRQ empleadoPagoRQ : empleadoPagoRQList) {
            EmpleadoPago empleadoPago = EmpleadoPago.builder()
                    .numeroCuenta(empleadoPagoRQ.getNumeroCuenta())
                    .valor(empleadoPagoRQ.getValor())
                    .estado("PEN")
                    .build();
    
            empleadosPago.add(empleadoPago);
        }
    
        return empleadosPago;
    }

    private boolean existenPagosEnMes(String mes) {
        List<PagoRol> pagosPorMes = pagoRolRepository.findByMes(mes);
        return pagosPorMes.isEmpty();
    }

    private void validacion(String mes, String ruc){
        List<PagoRol> pagosEmpresaMes = pagoRolRepository.findByMesAndRucEmpresa(mes, ruc);

        Empresa empresa = empresaRepository.findByRuc(ruc);
        

        for (PagoRol pagoRol : pagosEmpresaMes) {
            if(empresa.getEmpleado())
        }
    }
}
