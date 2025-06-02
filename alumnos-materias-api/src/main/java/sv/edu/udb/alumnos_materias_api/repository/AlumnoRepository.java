package sv.edu.udb.alumnos_materias_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.alumnos_materias_api.model.alumno;


public interface AlumnoRepository extends JpaRepository<alumno, Long> {

}
