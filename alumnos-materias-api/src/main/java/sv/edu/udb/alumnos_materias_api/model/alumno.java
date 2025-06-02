package sv.edu.udb.alumnos_materias_api.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private materia materia;
}
