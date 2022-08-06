package dio.intropadroesprojeto.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.intropadroesprojeto.model.Cliente;
import dio.intropadroesprojeto.model.Endereco;
import dio.intropadroesprojeto.repository.ClienteRepository;
import dio.intropadroesprojeto.repository.EnderecoRepository;
import dio.intropadroesprojeto.service.ClienteService;
import dio.intropadroesprojeto.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService cepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();        
    }

    @Override
    public Cliente buscarPorId(Long id) {        
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBancoDados = clienteRepository.findById(id);
        if (clienteBancoDados.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }
    
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verifica se o endereço do cliente já existe (pelo CEP)
        String cep = cliente.getEndereco().getCep();

        // o metodo orElseGet() faz uso de um callback para tratamento, 
        // caso o cep não seja encontrado. Podemos usar lambda aqui
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = cepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
    
}
