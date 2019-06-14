package ec.gob.caces.reactivo.servicio;

import ec.gob.caces.reactivo.modelo.Pregunta;
import ec.gob.caces.reactivo.repositorio.PreguntaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    public Pregunta saveOrUpdateProjectTask(Pregunta pregunta){
        return preguntaRepositorio.save(pregunta);
    }
    public Iterable<Pregunta> findAll(){
        return preguntaRepositorio.findAll();
    }

    public Pregunta findById(Long id){
        return preguntaRepositorio.getById(id);
    }

    public void delete(Long id){
        Pregunta pregunta = findById(id);
        preguntaRepositorio.delete(pregunta);
    }
}
