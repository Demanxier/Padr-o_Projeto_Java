package one.digitalinnovation.gof.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ItemVenda;
import one.digitalinnovation.gof.model.Venda;
import one.digitalinnovation.gof.model.VendaRepository;
import one.digitalinnovation.gof.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public Iterable<Venda> buscarTodos() {
        return vendaRepository.findAll();
    }

    @Override
    public Venda buscarPorId(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.get();
    }

    @Override
    public void calcularTotalVenda(Venda venda) {
        BigDecimal total = BigDecimal.ZERO;
        List<ItemVenda> itens = venda.getItens();
        for (ItemVenda item : itens) {
            BigDecimal subtotalItem = item.getProduto().getValor().multiply(item.getQuantidade());
            total = total.add(subtotalItem);
        }
        venda.setTotal(total);
    }

    @Override
    public List<Venda> buscarVendasPorCliente(Cliente cliente) {
        return vendaRepository.findByCliente(cliente);
    }

    @Override
    public void inserir(Venda venda) {
        calcularTotalVenda(venda);
        vendaRepository.save(venda);
    }

    @Override
    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

}
