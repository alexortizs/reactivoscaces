package ec.gob.caces.reactivo.repositorio;
import ec.gob.caces.reactivo.modelo.Reactivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactivoRepositorio extends CrudRepository<Reactivo, Long> {

    Reactivo getById(Long id);

}

