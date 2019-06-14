package ec.gob.caces.reactivo.web;

import ec.gob.caces.reactivo.modelo.Respuesta;
import ec.gob.caces.reactivo.servicio.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/respuesta")
@CrossOrigin
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody Respuesta respuesta, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Respuesta newPT = respuestaService.saveOrUpdateProjectTask(respuesta);

        return new ResponseEntity<Respuesta>(newPT, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public Iterable<Respuesta> getAllPTs(){
        return respuestaService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        Respuesta respuesta = respuestaService.findById(pt_id);
        return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        respuestaService.delete(pt_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

}
