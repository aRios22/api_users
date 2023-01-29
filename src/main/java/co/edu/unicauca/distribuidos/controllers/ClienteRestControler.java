package co.edu.unicauca.distribuidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean login(@RequestBody CredencialesDTO credenciales) {
        return UsuarioService.validarCredenciales(credenciales);
    }

    @PostMapping("/create")
	public UsuarioDTO create(@RequestBody UsuarioDTO user) {	
		UsuarioDTO objUser = null;
		objUser =  UsuarioService.save(user);
		return objUser;
    }

}
