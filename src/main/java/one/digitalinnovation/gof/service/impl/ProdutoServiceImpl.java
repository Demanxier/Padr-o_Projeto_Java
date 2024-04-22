package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.model.ProdutoRepository;
import one.digitalinnovation.gof.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Iterable<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    @Override
    public void inserir(Produto produto) {
        salvarProduto(produto);
    }

    public void atualizar(Long id, Produto produto) {
        // Buscar Produto por ID, caso exista:
        Optional<Produto> produtoBd = produtoRepository.findById(id);
        if (produtoBd.isPresent()) {
            salvarProduto(produto);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Produto por ID.
        produtoRepository.deleteById(id);
    }

    private void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    };
}
