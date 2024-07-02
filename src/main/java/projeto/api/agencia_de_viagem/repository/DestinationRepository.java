package projeto.api.agencia_de_viagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import projeto.api.agencia_de_viagem.model.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByNameContainingOrLocationContaining(String name, String location);

}