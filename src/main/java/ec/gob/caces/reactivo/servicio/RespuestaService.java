
package ec.gob.caces.reactivo.servicio;
import ec.gob.caces.reactivo.modelo.Respuesta;
import ec.gob.caces.reactivo.repositorio.RespuestaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepositorio respuestaRepositorio;

    public Respuesta saveOrUpdateProjectTask(Respuesta respuesta){
        return respuestaRepositorio.save(respuesta);
    }

    public Iterable<Respuesta> findAll(){
        return respuestaRepositorio.findAll();
    }

    public Respuesta findById(Long id){
        return respuestaRepositorio.getById(id);
    }

    public void delete(Long id){
        Respuesta respuesta = findById(id);
        respuestaRepositorio.delete(respuesta);
    }

}
