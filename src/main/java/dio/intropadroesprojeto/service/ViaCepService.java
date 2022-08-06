package dio.intropadroesprojeto.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dio.intropadroesprojeto.model.Endereco;

/**
 * Client HTTP, criado via <b>Open Feign</b> para consumo da API
 * do <b>Via Cep</b>
 * 
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud Open Feign</a>
 * @see <a href="https://viacep.com.br/">Via Cep</a>
 * 
 * @author fakynno
 */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
