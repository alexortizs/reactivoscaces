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
@Table(schema = "examen", name = "respuesta_evaluacion")
@SequenceGenerator(name = "respuesta_evaluacion_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "respuesta_evaluacion_id_seq")

public class RespuestaEvaluacion implements Serializable {
    private static final long serialVersionUID = -3041066380341805825L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "respuesta_evaluacion_id_seq")
    private Long id;

    @ManyToOne(targetEntity = Respuesta.class)
    @JoinColumn(name = "id_respuesta")
    private Respuesta respuesta;

    @ManyToOne(targetEntity = Reactivo.class)
    @JoinColumn(name = "id_reactivo")
    private Reactivo reactivo;

    @ManyToOne(targetEntity = Evaluacion.class)
    @JoinColumn(name = "id_evaluacion")
    private Evaluacion evaluacion;

    @ManyToOne(targetEntity = RespuestaEvaluacionOrden.class)
    @JoinColumn(name = "id_respuesta_evaluacion_orden")
    private RespuestaEvaluacionOrden respuestaEvaluacionOrden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
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

    public RespuestaEvaluacionOrden getRespuestaEvaluacionOrden() {
        return respuestaEvaluacionOrden;
    }

    public void setRespuestaEvaluacionOrden(RespuestaEvaluacionOrden respuestaEvaluacionOrden) {
        this.respuestaEvaluacionOrden = respuestaEvaluacionOrden;
    }
}


