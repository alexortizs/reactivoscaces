package ec.gob.caces.reactivo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(schema = "examen", name = "pregunta")
@SequenceGenerator(name = "pregunta_id_seq", initialValue = 1,
        allocationSize = 1, catalog = "examen", sequenceName = "pregunta_id_seq")

public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pregunta_id_seq")
    private Long id;

    @NotBlank(message = "Summary cannot be blank")
    private String pregunta;
    private String formulacion;
    private Boolean activo;
    private String usuarioModificacion;

    @Column(name = "estado_pregunta")
    private String estado;

    @ManyToOne(targetEntity = Grupo.class)
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    public Pregunta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(String formulacion) {
        this.formulacion = formulacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
