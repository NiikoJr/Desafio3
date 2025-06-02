package sv.edu.udb.alumnos_materias_api.controller;
import sv.edu.udb.alumnos_materias_api.model.alumno;
import sv.edu.udb.alumnos_materias_api.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<alumno> listarAlumnos() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<alumno> obtenerAlumno(@PathVariable Long id) {
        return alumnoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public alumno crearAlumno(@RequestBody alumno alumno) {
        return alumnoService.crear(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<alumno> actualizarAlumno(@PathVariable Long id, @RequestBody alumno alumno) {
        try {
            return ResponseEntity.ok(alumnoService.actualizar(id, alumno));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
