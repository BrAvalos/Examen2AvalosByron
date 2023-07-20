package ec.edu.espe.examen2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.espe.examen2.controller.dto.PagoRolRQ;
import ec.edu.espe.examen2.service.PagoRolService;

@RestController
@RequestMapping("/api/v1/pagorol")
public class PagoRolController {
    private final PagoRolService service;

    public PagoRolController(PagoRolService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity createEmpresa(@RequestBody PagoRolRQ pagoRol){
        this.service.createPagoRol(pagoRol);
        return ResponseEntity.ok().build();
    }
}
