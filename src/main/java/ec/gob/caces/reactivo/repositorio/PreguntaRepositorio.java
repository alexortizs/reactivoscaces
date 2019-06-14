package ec.gob.caces.reactivo.repositorio;

import ec.gob.caces.reactivo.modelo.Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepositorio extends CrudRepository<Pregunta, Long> {

    Pregunta getById(Long id);

}
