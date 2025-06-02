package sv.edu.udb.alumnos_materias_api.repository;
import sv.edu.udb.alumnos_materias_api.model.materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<materia, Long> {

}
