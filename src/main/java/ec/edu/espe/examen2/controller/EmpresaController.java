package ec.edu.espe.examen2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen2.controller.dto.EmpresaRQ;
import ec.edu.espe.examen2.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    private final EmpresaService service;

    public EmpresaController(EmpresaService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity createEmpresa(@RequestBody EmpresaRQ empresa){
        this.service.createEmpresa(empresa);
        return ResponseEntity.ok().build();
    }
}
