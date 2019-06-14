package ec.gob.caces.reactivo.web;

import ec.gob.caces.reactivo.modelo.Reactivo;
import ec.gob.caces.reactivo.servicio.ReactivoService;
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
@RequestMapping("/api/reactivo")
@CrossOrigin
public class ReactivoController {

    @Autowired
    private ReactivoService reactivoService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody Reactivo reactivo, BindingResult result){

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Reactivo newPT = reactivoService.saveOrUpdateProjectTask(reactivo);

        return new ResponseEntity<Reactivo>(newPT, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public Iterable<Reactivo> getAllPTs(){
        return reactivoService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long pt_id){
        Reactivo reactivo = reactivoService.findById(pt_id);
        return new ResponseEntity<Reactivo>(reactivo, HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        reactivoService.delete(pt_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

}
