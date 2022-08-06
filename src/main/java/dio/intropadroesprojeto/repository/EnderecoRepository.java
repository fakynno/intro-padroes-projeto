package dio.intropadroesprojeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.intropadroesprojeto.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{
    
}
