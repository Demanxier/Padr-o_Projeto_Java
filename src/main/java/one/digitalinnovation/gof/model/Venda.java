package one.digitalinnovation.gof.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemVenda> itens = new ArrayList<>();

    private BigDecimal total;

    public void adicionarItem(Produto produto, BigDecimal quantidade) {
        // Verifica se o produto está disponivel e estoque
        if (produto.getQuantidade().compareTo(quantidade) >= 0) {
            // Adicionando o item a lista da venda
            itens.add(new ItemVenda(produto, quantidade));
            // Atualiza o estoque do produto
            produto.setQuantidade(produto.getQuantidade().subtract(quantidade));
        } else {
            throw new IllegalArgumentException("Quantidade indisponivel em estoque!" + produto.getNome());
        }
    }

    public Venda(Long id, Cliente cliente, List<ItemVenda> itens) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
