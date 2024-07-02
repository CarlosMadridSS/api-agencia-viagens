package projeto.api.agencia_de_viagem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projeto.api.agencia_de_viagem.model.AgencyUser;
import projeto.api.agencia_de_viagem.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        Optional<AgencyUser> agencyUser = Optional.ofNullable(userRepository.findByUsername(username));
        return agencyUser.map(AuthenticatedUser::new).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado!"));
    }
}
