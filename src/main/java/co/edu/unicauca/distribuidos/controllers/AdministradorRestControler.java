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

import co.edu.unicauca.distribuidos.models.Administrador;
import co.edu.unicauca.distribuidos.services.Administrador.IAdministradorServicio;
import co.edu.unicauca.distribuidos.services.DTO.AdministradorDTO;
import co.edu.unicauca.distribuidos.services.DTO.CredencialesDTO;

@RestController
@RequestMapping("/api/admin")
public class AdministradorRestControler {

    @Autowired
    private IAdministradorServicio AdministradorService;


    @GetMapping("/admins")
    public ResponseEntity<List<Administrador>> index() {
        return new ResponseEntity<List<Administrador>>(AdministradorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody CredencialesDTO credenciales) {
        AdministradorDTO result = AdministradorService.validarCredenciales(credenciales);
        if(result != null){
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credenciales inválidas.");
        }
    }

    @PostMapping("/create")
	public ResponseEntity create(@Valid @RequestBody  AdministradorDTO admin, BindingResult result) {	
		AdministradorDTO objAdmin = null;
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result.getFieldErrors()); 
        }
		objAdmin =  AdministradorService.save(admin);

		if (objAdmin != null) {
            return ResponseEntity.status(HttpStatus.OK).body(objAdmin);
        } else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El nombre de usuario ya existe.");
        }
    }
}
