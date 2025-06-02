package sv.edu.udb.alumnos_materias_api.service;
import sv.edu.udb.alumnos_materias_api.model.materia;
import sv.edu.udb.alumnos_materias_api.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<materia> obtenerTodas() {
        return materiaRepository.findAll();
    }

    public Optional<materia> obtenerPorId(Long id) {
        return materiaRepository.findById(id);
    }

    public materia crear(materia materia) {
        return materiaRepository.save(materia);
    }

    public materia actualizar(Long id, materia materiaActualizada) {
        return materiaRepository.findById(id).map(materia -> {
            materia.setNombre(materiaActualizada.getNombre());
            return materiaRepository.save(materia);
        }).orElseThrow(() -> new RuntimeException("Materia no encontrada"));
    }

    public void eliminar(Long id) {
        materiaRepository.deleteById(id);
    }
}
