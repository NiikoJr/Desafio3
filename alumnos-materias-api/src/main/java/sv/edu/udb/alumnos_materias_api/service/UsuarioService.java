package sv.edu.udb.alumnos_materias_api.service;

import sv.edu.udb.alumnos_materias_api.model.Usuario;
import sv.edu.udb.alumnos_materias_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null) throw new UsernameNotFoundException("Usuario no encontrado");

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(usuario.getRol())));
    }
}
