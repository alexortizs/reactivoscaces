package ec.gob.caces.reactivo.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(schema = "examen", name = "evaluacion")
@SequenceGenerator(name = "evaluacion_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "evaluacion_id_seq")
public class Evaluacion implements Serializable {
    private static final long serialVersionUID = -3041066390241805824L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluacion_id_seq")
    private Long id;

    @Column(name = "numero_evaluacion")
    private Long numeroEvaluacion;

    @Column(name = "id_inscripcion")
    private Long idInscripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroEvaluacion() {
        return numeroEvaluacion;
    }

    public void setNumeroEvaluacion(Long numeroEvaluacion) {
        this.numeroEvaluacion = numeroEvaluacion;
    }

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
}

