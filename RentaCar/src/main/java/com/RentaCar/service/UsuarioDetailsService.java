
package com.RentaCar.service;

import com.RentaCar.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UsuarioDetailsService {
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    public Usuario getUsuarioPorUsername(String username);
}
