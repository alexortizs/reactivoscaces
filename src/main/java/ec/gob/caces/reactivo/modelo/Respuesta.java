package ec.gob.caces.reactivo.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "examen", name = "respuesta")
@SequenceGenerator(name = "respuesta_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "respuesta_id_seq")
public class Respuesta implements Serializable {

    private static final long serialVersionUID = -3041066390241805814L;

    /**
     * Identificador de la respuesta
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "respuesta_id_seq")
    private Long id;

    /**
     * Valor de la respuesta
     */
    @Column(columnDefinition = "text")
    private String valor;

    /**
     * Es verdadero si la respuesta posee texto enriquecido
     */
    @Column
    private Boolean esValorTextoEnriquecido;

    /**
     * Almacena la argumentacion del Reactivo
     */
    @Column(columnDefinition = "text")
    private String argumentacion;

    /**
     * Es verdadero si la argumentacion posee texto enriquecido
     */
    @Column
    private Boolean esArgumentacionTextoEnriquecido;

    /**
     * Es verdadero si la respuesta es la correcta
     */
    @Column(columnDefinition = "boolean default false", nullable = false)
    private Boolean correcta;

    /**
     * Llave cifrada
     */
    @Column(name = "llave_cifrada", columnDefinition = "text", nullable = false)
    private String llaveCifrada;

    /**
     * Representa la relacion con la Entidad Reactivo
     */
    @ManyToOne
    @JoinColumn(name = "id_reactivo")
    private Reactivo reactivo;

    /**
     * Determina si la asignación existe. False indica borrado lógico
     */
    @Column(nullable = false)
    private Boolean activo;

    /**
     * Representa el orden de la respuesta
     */
    @Column(name = "orden")
    private Integer orden;

    public Respuesta() {
        esArgumentacionTextoEnriquecido = false;
        esValorTextoEnriquecido = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getArgumentacion() {
        return argumentacion;
    }

    public void setArgumentacion(String argumentacion) {
        this.argumentacion = argumentacion;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    public Reactivo getReactivo() {
        return reactivo;
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }

    public Boolean getEsValorTextoEnriquecido() {
        return esValorTextoEnriquecido;
    }

    public void setEsValorTextoEnriquecido(Boolean esValorTextoEnriquecido) {
        this.esValorTextoEnriquecido = esValorTextoEnriquecido;
    }

    public Boolean getEsArgumentacionTextoEnriquecido() {
        return esArgumentacionTextoEnriquecido;
    }

    public void setEsArgumentacionTextoEnriquecido(Boolean esArgumentacionTextoEnriquecido) {
        this.esArgumentacionTextoEnriquecido = esArgumentacionTextoEnriquecido;
    }

    public String getLlaveCifrada() {
        return llaveCifrada;
    }

    public void setLlaveCifrada(String llaveCifrada) {
        this.llaveCifrada = llaveCifrada;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }


}

