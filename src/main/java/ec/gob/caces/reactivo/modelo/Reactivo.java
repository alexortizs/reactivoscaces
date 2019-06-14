package ec.gob.caces.reactivo.modelo;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;
        import javax.persistence.CascadeType;
        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.FetchType;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.JoinColumn;
        import javax.persistence.ManyToOne;
        import javax.persistence.OneToMany;
        import javax.persistence.SequenceGenerator;
        import javax.persistence.Table;
        import javax.persistence.Transient;

@Entity
@Table(schema = "examen", name = "reactivo")
@SequenceGenerator(name = "reactivo_id_seq", initialValue = 1,
        allocationSize = 1, schema = "examen", sequenceName = "reactivo_id_seq")
public class Reactivo implements Serializable {

    private static final long serialVersionUID = -7217202629481722295L;

    /**
     * Identificador de la entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reactivo_id_seq")
    private Long id;

    /**
     * Almacena el id del tema al que pertenece el reactivo
     */
    @Column(name = "id_tema")
    private Long idTema;

    /**
     * Referencia al tema que pertenece el reactivo
     */
    @Transient
    private Grupo tema;

    /**
     * Almacena la referencia a la entidad Lengua
     */
    @Column(name = "id_lengua")
    private Long idLengua;

    /**
     * Almacena la referencia a la entidad Idioma
     */
    @Column(name = "id_idioma")
    private Long idIdioma;

    /**
     * Almacena la referencia a la entidad Nivel
     */
    @Column(name = "id_nivel")
    private Long idNivel;

    /**
     * Referencia a la entidad Nivel
     */

    /**
     * Almacena la referencia a la entidad Escala Campo
     */
    @Column(name = "id_escala_aprendizaje")
    private Long idEscalaAprendizaje;

    /**
     * Referencia a la entidad EscalaAprendizaje
     */

    /**
     * Almacena la referencia a la entidad Grado de Dificultad
     */
    @Column(name = "id_grado_dificultad")
    private Long idGradoDificultad;

    /**
     * Referencia a la entidad GradoDificultad
     */

    /**
     * Almacena la formulacion del reactivo
     */
    @Column(columnDefinition = "text")
    private String formulacion;

    /**
     * Es verdadero si la formulacion posee texto enriquecido
     */
    @Column
    private Boolean esFormulacionTextoEnriquecido;

    /**
     * Almacena la bibliografia del Reactivo
     */
    @Column(columnDefinition = "text")
    private String bibliografia;

    /**
     * Es verdadero si la bibliografia posee texto enriquecido
     */
    @Column
    private Boolean esBibliografiaTextoEnriquecido;

    /**
     * Listado de respuestas de la formulacion del reactivo
     */
    /*@OneToMany(mappedBy = "reactivo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;*/

    /**
     * Almacena el estado del reactivo
     */
    @Column
    private String estado;

    /**
     * Academico que creo el reactivo
     */
    @Column(name = "id_academico")
    private String idAcademico;

    /**
     * Academico al que fue asignado el reactivo
     */
    @Column(name = "id_experto_academico")
    private String idExpertoAcademico;

    /**
     * Identificador del proceso BPM asociado al reactivo
     */
    @Column(name = "id_proceso_bpm")
    private Long idProcesoBPM;

    /**
     * Identificador del proceso para el que fue elaborado el reactivo
     */
    @Column(name = "id_proceso_elaboracion")
    private Long idProcesoElaboracion;

    /**
     * Comentarios del Validador del Reactivo
     */
    @Column(name = "comentarios_validador")
    private String comentariosValidador;

    /**
     * Llave con la que cifra el reactivo
     */
    @Column(name = "llave_cifrada", columnDefinition = "text", nullable = false)
    private String llaveCifrada;

    /**
     * Determina si la asignación existe. False indica borrado lógico
     */
    @Column(nullable = false)
    private Boolean activo;

    @Column(name = "respuesta_jerarquica")
    private Boolean respuestaJerarquica;

    @Transient
    private Boolean validarTarea;

    /**
     * Referencia a la tarea del flujo BPM
     */
    @Transient
    private Long idTareaBPM;

    /**
     * Almacena la referencia a la entidad Nivel Competencia Campo
     */
    @Column(name = "id_nivel_competencia_campo")
    private Long idNivelCompetenciaCampo;

    /**
     * Referencia a la entidad NivelCompetencia
     */

    @ManyToOne
    @JoinColumn(name = "id_reactivo_padre")
    private Reactivo reactivoPadre;

    @Column(name = "observacion_examen")
    private String observacionExamen;

    /**
     * Campo String para Uso libre dentro de la entidad Reactivo
     */
    @Transient
    private String nombres;

    /**
     * Codigo Reactivo - Carga masiva
     */
    @Column(name = "codigo_reactivo")
    private String codigoReactivo;

    /**
     * Codigo Reactivo - Carga masiva
     */
    @Column(name = "examen")
    private Boolean examen;

    /**
     * Bandera para determinar si el rectivoes apto para reposicion si
     * no está agregado en el examen principal
     */
    @Transient
    private Boolean esApto;

    public Reactivo() {

        this.activo = Boolean.TRUE;
        this.esFormulacionTextoEnriquecido = false;
        this.esBibliografiaTextoEnriquecido = false;

    }

    public Reactivo(String idAcademico, Long proceso) {
        this();
        this.idAcademico = idAcademico;
        this.idProcesoElaboracion = proceso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grupo getTema() {
        return tema;
    }

    public void setTema(Grupo tema) {
        this.tema = tema;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public Long getIdEscalaAprendizaje() {
        return idEscalaAprendizaje;
    }

    public void setIdEscalaAprendizaje(Long idEscalaAprendizaje) {
        this.idEscalaAprendizaje = idEscalaAprendizaje;
    }

    public Long getIdGradoDificultad() {
        return idGradoDificultad;
    }

    public void setIdGradoDificultad(Long idGradoDificultad) {
        this.idGradoDificultad = idGradoDificultad;
    }

    public String getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(String formulacion) {
        this.formulacion = formulacion;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdTema() {
        return idTema;
    }

    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }

    public Long getIdLengua() {
        return idLengua;
    }

    public void setIdLengua(Long idLengua) {
        this.idLengua = idLengua;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Boolean getEsFormulacionTextoEnriquecido() {
        return esFormulacionTextoEnriquecido;
    }

    public void setEsFormulacionTextoEnriquecido(Boolean esFormulacionTextoEnriquecido) {
        this.esFormulacionTextoEnriquecido = esFormulacionTextoEnriquecido;
    }

    public Boolean getEsBibliografiaTextoEnriquecido() {
        return esBibliografiaTextoEnriquecido;
    }

    public void setEsBibliografiaTextoEnriquecido(Boolean esBibliografiaTextoEnriquecido) {
        this.esBibliografiaTextoEnriquecido = esBibliografiaTextoEnriquecido;
    }

    public Long getIdTareaBPM() {
        return idTareaBPM;
    }

    public void setIdTareaBPM(Long idTareaBPM) {
        this.idTareaBPM = idTareaBPM;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public Long getIdProcesoBPM() {
        return idProcesoBPM;
    }

    public void setIdProcesoBPM(Long idProcesoBPM) {
        this.idProcesoBPM = idProcesoBPM;
    }

    public String getIdExpertoAcademico() {
        return idExpertoAcademico;
    }

    public void setIdExpertoAcademico(String idExpertoAcademico) {
        this.idExpertoAcademico = idExpertoAcademico;
    }

    public Long getIdProcesoElaboracion() {
        return idProcesoElaboracion;
    }

    public void setIdProcesoElaboracion(Long idProcesoElaboracion) {
        this.idProcesoElaboracion = idProcesoElaboracion;
    }

    public String getComentariosValidador() {
        return comentariosValidador;
    }

    public void setComentariosValidador(String comentariosValidador) {
        this.comentariosValidador = comentariosValidador;
    }

    public String getLlaveCifrada() {
        return llaveCifrada;
    }

    public void setLlaveCifrada(String llaveCifrada) {
        this.llaveCifrada = llaveCifrada;
    }

    public Boolean getValidarTarea() {
        return validarTarea;
    }

    public void setValidarTarea(Boolean validarTarea) {
        this.validarTarea = validarTarea;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getIdNivelCompetenciaCampo() {
        return idNivelCompetenciaCampo;
    }

    public void setIdNivelCompetenciaCampo(Long idNivelCompetenciaCampo) {
        this.idNivelCompetenciaCampo = idNivelCompetenciaCampo;
    }


    @Override
    public boolean equals(Object obj) {
        Reactivo reactivo = (Reactivo) obj;
        return reactivo != null && getId() != null
                && reactivo.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public Reactivo getReactivoPadre() {
        return reactivoPadre;
    }

    public void setReactivoPadre(Reactivo reactivoPadre) {
        this.reactivoPadre = reactivoPadre;
    }

    public String getObservacionExamen() {
        return observacionExamen;
    }

    public void setObservacionExamen(String observacionExamen) {
        this.observacionExamen = observacionExamen;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Boolean getRespuestaJerarquica() {
        return respuestaJerarquica;
    }

    public void setRespuestaJerarquica(Boolean respuestaJerarquica) {
        this.respuestaJerarquica = respuestaJerarquica;
    }

    public String getCodigoReactivo() {
        return codigoReactivo;
    }

    public void setCodigoReactivo(String codigoReactivo) {
        this.codigoReactivo = codigoReactivo;
    }

    public Boolean getEsApto() {
        return esApto;
    }

    public void setEsApto(Boolean esApto) {
        this.esApto = esApto;
    }

    public Boolean getExamen() {
        return examen;
    }

    public void setExamen(Boolean examen) {
        this.examen = examen;
    }


}
