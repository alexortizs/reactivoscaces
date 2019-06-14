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
@Table(schema = "examen", name = "respuesta_evaluacion_orden")
@SequenceGenerator(name = "respuesta_evaluacion_orden_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "respuesta_evaluacion_orden_id_seq")

public class RespuestaEvaluacionOrden implements Serializable {
    private static final long serialVersionUID = -3041066390341805825L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "respuesta_evaluacion_orden_id_seq")
    private Long id;

    @ManyToOne(targetEntity = Reactivo.class)
    @JoinColumn(name = "id_reactivo_evaluacion_orden")
    private ReactivoEvaluacionOrden reactivoevaluacionorden;

    @ManyToOne(targetEntity = Evaluacion.class)
    @JoinColumn(name = "id_evaluacion")
    private Evaluacion evaluacion;

    @ManyToOne(targetEntity = Respuesta.class)
    @JoinColumn(name = "id_respuesta")
    private Respuesta respuesta;

    @Column(name = "orden")
    private Long orden;

    @Column(columnDefinition = "text")
    private String literal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReactivoEvaluacionOrden getReactivoevaluacionorden() {
        return reactivoevaluacionorden;
    }

    public void setReactivoevaluacionorden(ReactivoEvaluacionOrden reactivoevaluacionorden) {
        this.reactivoevaluacionorden = reactivoevaluacionorden;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }
}

