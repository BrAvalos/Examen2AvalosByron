package ec.edu.espe.examen2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import ec.edu.espe.examen2.model.PagoRol;

public interface PagoRolRepository extends MongoRepository<PagoRol, String>  {
    List<PagoRol> findByMes(String mes);
    List<PagoRol> findByMesAndRucEmpresa(String mes, String ruc);
}
