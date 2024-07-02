package projeto.api.agencia_de_viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.api.agencia_de_viagem.model.AgencyUser;
import projeto.api.agencia_de_viagem.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<AgencyUser> findAll(){
        return userRepository.findAll();
    }

    public AgencyUser save(AgencyUser agencyUser) {
        return userRepository.save(
                agencyUser.convertToEntity(
                        agencyUser.getId(),
                        agencyUser.getName(),
                        agencyUser.getUser(),
                        agencyUser.getPassword(),
                        agencyUser.getRole()
                )
        );
    }

    public Optional<AgencyUser> findById(Long id) {
        return userRepository.findById(id);
    }

    public AgencyUser update(Long id, AgencyUser agencyUser) {
        agencyUser.setId(id);
        return userRepository.save(agencyUser);
    }

    public Void deleteById(Long id){
        userRepository.deleteById(id);
        return null;
    }

}
