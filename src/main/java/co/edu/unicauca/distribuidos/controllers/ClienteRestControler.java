package co.edu.unicauca.distribuidos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.models.Usuario;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;
import co.edu.unicauca.distribuidos.services.DTO.UsuarioDTO;
import co.edu.unicauca.distribuidos.services.Usuario.IUsuarioServicio;

@RestController
@RequestMapping("/api/user")
public class ClienteRestControler {
    
    @Autowired
    private IUsuarioServicio UsuarioService;

    @GetMapping("/users")
    public List<Usuario> users() {
        return UsuarioService.findAll();
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody CredencialesDTO credenciales) {
        Boolean result = UsuarioService.validarCredenciales(credenciales);
        if(result == true){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @PostMapping("/create")
	public ResponseEntity create(@Valid @RequestBody UsuarioDTO usuario, BindingResult result) {	
		UsuarioDTO objAdmin = null;
		objAdmin =  UsuarioService.save(usuario);
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result.getFieldErrors()); 
        }
		if (objAdmin != null) {
            return ResponseEntity.status(HttpStatus.OK).body(objAdmin);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El nombre de usuario ya existe.");
        }
    }

}
