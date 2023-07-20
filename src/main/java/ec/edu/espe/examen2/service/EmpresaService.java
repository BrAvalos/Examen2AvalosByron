package ec.edu.espe.examen2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen2.controller.dto.EmpleadoRQ;
import ec.edu.espe.examen2.controller.dto.EmpresaRQ;
import ec.edu.espe.examen2.model.Empleado;
import ec.edu.espe.examen2.model.Empresa;
import ec.edu.espe.examen2.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public void createEmpresa(EmpresaRQ empresaRQ){
        Empresa empresa = this.transform(empresaRQ);

        this.empresaRepository.save(empresa);
    }

    private Empresa transform(EmpresaRQ rq){
        return Empresa.builder().ruc(rq.getRuc())
                .razonSocial(rq.getRazonSocial())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleado(transformEmpleado(rq.getEmpleado()))
                .build();
    } 

    private List<Empleado> transformEmpleado(List<EmpleadoRQ> empleadoRQList) {
        List<Empleado> empleados = new ArrayList<>();
    
        for (EmpleadoRQ empleadoRQ : empleadoRQList) {
            Empleado empleado = Empleado.builder()
                    .cedulaIdentidad(empleadoRQ.getCedulaIdentidad())
                    .apellidos(empleadoRQ.getApellidos())
                    .nombres(empleadoRQ.getNombres())
                    .numeroCuenta(empleadoRQ.getNumeroCuenta())
                    .build();
    
            empleados.add(empleado);
        }
    
        return empleados;
    }
    
}
