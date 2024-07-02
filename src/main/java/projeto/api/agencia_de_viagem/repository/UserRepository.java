package projeto.api.agencia_de_viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.api.agencia_de_viagem.model.AgencyUser;

@Repository
public interface UserRepository extends JpaRepository<AgencyUser, Long> {
    AgencyUser findByUsername(String username);
}
