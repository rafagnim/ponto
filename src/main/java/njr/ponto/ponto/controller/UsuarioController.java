package njr.ponto.ponto.controller;

import njr.ponto.ponto.model.Usuario;
import njr.ponto.ponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getUsuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getusuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return  ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Usuario updateusuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{idJUsuario}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByID(@PathVariable("idUsuario") Long idJUsuario) throws Exception {
        usuarioService.deleteUsuario(idJUsuario);
    }
}
