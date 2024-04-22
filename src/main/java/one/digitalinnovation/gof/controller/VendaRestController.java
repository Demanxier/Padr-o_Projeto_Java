package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import one.digitalinnovation.gof.model.Venda;
import one.digitalinnovation.gof.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaRestController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<Iterable<Venda>> buscarTodasVendas() {
        Iterable<Venda> vendas = vendaService.buscarTodos();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        Venda venda = vendaService.buscarPorId(id);
        return ResponseEntity.ok(venda);
    }

    @PostMapping
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        vendaService.inserir(venda);
        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
