package dio.intropadroesprojeto.service;

import dio.intropadroesprojeto.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy<b> no domínio do cliente.
 * Caso necessário, podemos ter múltiplas implementações da mesma interface.
 * 
 * @author fakynno
 */

public interface ClienteService {
    
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
