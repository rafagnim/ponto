package njr.ponto.ponto.controller;

import njr.ponto.ponto.model.Empresa;
import njr.ponto.ponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa createJornada(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getJEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        return  ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        empresaService.deleteEmpresa(idEmpresa);
    }
}
