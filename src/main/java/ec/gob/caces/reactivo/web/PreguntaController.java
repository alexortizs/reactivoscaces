package ec.gob.caces.reactivo.web;

import ec.gob.caces.reactivo.modelo.Pregunta;
import ec.gob.caces.reactivo.servicio.PreguntaService;
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
@RequestMapping("/api/pregunta")
@CrossOrigin
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody Pregunta pregunta, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Pregunta newPT = preguntaService.saveOrUpdateProjectTask(pregunta);

        return new ResponseEntity<Pregunta>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Pregunta> getAllPTs(){
        return preguntaService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        Pregunta pregunta = preguntaService.findById(pt_id);
        return new ResponseEntity<Pregunta>(pregunta, HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        preguntaService.delete(pt_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

}
