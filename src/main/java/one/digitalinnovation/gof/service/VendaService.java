package one.digitalinnovation.gof.service;

import java.util.List;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Venda;

public interface VendaService {

    Iterable<Venda> buscarTodos();

    Venda buscarPorId(Long id);

    void calcularTotalVenda(Venda venda);

    List<Venda> buscarVendasPorCliente(Cliente cliente);

    void inserir(Venda venda);

    void deletar(Long id);
}
