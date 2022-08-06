package dio.intropadroesprojeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.intropadroesprojeto.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    
}
