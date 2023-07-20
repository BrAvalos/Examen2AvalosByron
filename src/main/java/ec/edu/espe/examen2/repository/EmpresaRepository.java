package ec.edu.espe.examen2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.examen2.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    Empresa findByRuc(String ruc);
}
