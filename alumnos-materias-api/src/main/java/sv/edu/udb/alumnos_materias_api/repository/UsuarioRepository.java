package sv.edu.udb.alumnos_materias_api.repository;

import sv.edu.udb.alumnos_materias_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
