package one.digitalinnovation.gof.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long> {
    List<Venda> findByCliente(Cliente cliente);

}
