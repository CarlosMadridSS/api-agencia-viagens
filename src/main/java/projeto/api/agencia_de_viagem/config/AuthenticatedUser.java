package projeto.api.agencia_de_viagem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.api.agencia_de_viagem.model.AgencyUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthenticatedUser implements UserDetails {

    @Autowired
    private AgencyUser agencyUser;


    public AuthenticatedUser (AgencyUser agencyUser) {
        this.agencyUser = agencyUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + agencyUser.getRole());
        authorities.add(authority);
        return authorities ;
    }

    @Override
    public String getPassword() {
        return agencyUser.getPassword();
    }

    @Override
    public String getUsername() {
        return agencyUser.getUser();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
