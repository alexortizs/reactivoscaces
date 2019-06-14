package ec.gob.caces.reactivo.repositorio;

import ec.gob.caces.reactivo.modelo.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    ProjectTask getById(Long id);

}
