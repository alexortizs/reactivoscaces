package ec.gob.caces.reactivo.servicio;
import ec.gob.caces.reactivo.modelo.Reactivo;
import ec.gob.caces.reactivo.repositorio.ReactivoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactivoService {

    @Autowired
    private ReactivoRepositorio reactivoRepositorio;

    public Reactivo saveOrUpdateProjectTask(Reactivo reactivo){
        return reactivoRepositorio.save(reactivo);
    }

    public Iterable<Reactivo> findAll(){
        return reactivoRepositorio.findAll();
    }

    public Reactivo findById(Long id){
        return reactivoRepositorio.getById(id);
    }

    public void delete(Long id){
        Reactivo reactivo = findById(id);
        reactivoRepositorio.delete(reactivo);
    }

}
