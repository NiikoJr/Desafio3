package sv.edu.udb.alumnos_materias_api.controller;
import sv.edu.udb.alumnos_materias_api.model.materia;
import sv.edu.udb.alumnos_materias_api.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")

public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<materia> listarMaterias() {
        return materiaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<materia> obtenerMateria(@PathVariable Long id) {
        return materiaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public materia crearMateria(@RequestBody materia materia) {
        return materiaService.crear(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<materia> actualizarMateria(@PathVariable Long id, @RequestBody materia materia) {
        try {
            return ResponseEntity.ok(materiaService.actualizar(id, materia));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMateria(@PathVariable Long id) {
        materiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
