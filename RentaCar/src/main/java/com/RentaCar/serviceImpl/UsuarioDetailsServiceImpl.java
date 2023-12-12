
package com.RentaCar.serviceImpl;

import com.RentaCar.dao.UsuarioDao;
import com.RentaCar.domain.Rol;
import com.RentaCar.domain.Usuario;
import com.RentaCar.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por el username en la BD
        Usuario usuario = usuarioDao.findByUsername(username);
        // Si no existe el usuario lanza una excepcion
        if (usuario == null){
            throw new UsernameNotFoundException(username);
        }
        // Si llego aca es porque el usuario existe en la db
        // Remover atributos de la sesion
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getImagen());
        // Transformar roles a gratedauthority
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol item : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(item.getNombre()));
        }
        // Se retorna el User (Clase UserDetails)
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
}
