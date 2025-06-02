package sv.edu.udb.alumnos_materias_api.service;
import sv.edu.udb.alumnos_materias_api.model.alumno;
import sv.edu.udb.alumnos_materias_api.model.materia;
import sv.edu.udb.alumnos_materias_api.repository.AlumnoRepository;
import sv.edu.udb.alumnos_materias_api.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public List<alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    public Optional<alumno> obtenerPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public alumno crear(alumno alumno) {
        // Verificar que la materia asociada existe
        materia materia = materiaRepository.findById(alumno.getMateria().getId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        alumno.setMateria(materia);
        return alumnoRepository.save(alumno);
    }

    public alumno actualizar(Long id, alumno alumnoActualizado) {
        return alumnoRepository.findById(id).map(alumno -> {
            alumno.setNombre(alumnoActualizado.getNombre());
            alumno.setApellido(alumnoActualizado.getApellido());
            // Verificar que la nueva materia existe
            materia materia = materiaRepository.findById(alumnoActualizado.getMateria().getId())
                    .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
            alumno.setMateria(materia);
            return alumnoRepository.save(alumno);
        }).orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
    }

    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }
}
