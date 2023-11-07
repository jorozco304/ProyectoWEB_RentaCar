package com.RentaCar.service;

import com.RentaCar.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
    public List<Usuario> getUsuarios(boolean activos);
    
    public Usuario getUsuario(Usuario usuario);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);
}
