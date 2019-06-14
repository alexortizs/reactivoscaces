package ec.gob.caces.reactivo.repositorio;

import ec.gob.caces.reactivo.modelo.Respuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RespuestaRepositorio extends CrudRepository<Respuesta, Long> {

    Respuesta getById(Long id);

}

