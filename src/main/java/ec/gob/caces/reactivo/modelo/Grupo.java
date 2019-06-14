package ec.gob.caces.reactivo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;


@Entity
@Table(schema = "examen", name = "grupo")
@SequenceGenerator(name = "grupo_id_seq", initialValue = 1,
        allocationSize = 1, catalog = "examen", sequenceName = "grupo_id_seq")

public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grupo_id_seq")
    private Long id;

    @Column(name = "grupo")
    private String grupo;

    public Grupo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}

