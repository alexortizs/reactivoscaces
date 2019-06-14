package ec.gob.caces.reactivo.modelo;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(schema = "examen", name = "reactivo_evaluacion_orden")
@SequenceGenerator(name = "reactivo_evaluacion_orden_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "reactivo_evaluacion_orden_id_seq")
public class ReactivoEvaluacionOrden implements Serializable {
    private static final long serialVersionUID = -3041066390241805825L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reactivo_evaluacion_orden_id_seq")
    private Long id;

    @ManyToOne(targetEntity = Reactivo.class)
    @JoinColumn(name = "id_reactivo")
    private Reactivo reactivo;

    @ManyToOne(targetEntity = Evaluacion.class)
    @JoinColumn(name = "id_evaluacion")
    private Evaluacion evaluacion;

    @Column(name = "numero_pregunta")
    private Long numeroPregunta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reactivo getReactivo() {
        return reactivo;
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Long getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(Long numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }
}