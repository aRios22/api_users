package co.edu.unicauca.distribuidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Administrador> index() {
        return AdministradorService.findAll();
    }

    @GetMapping("/login")
    public boolean login(@RequestBody CredencialesDTO credenciales) {
        return AdministradorService.validarCredenciales(credenciales);
    }

    @PostMapping("/create")
	public AdministradorDTO create(@RequestBody AdministradorDTO admin) {	
		AdministradorDTO objAdmin = null;
		objAdmin =  AdministradorService.save(admin);
		return objAdmin;
    }
}
