package co.edu.unicauca.distribuidos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.models.Administrador;
import co.edu.unicauca.distribuidos.services.IAdministradorServicio;

@RestController
@RequestMapping("/api")
public class AdministradorRestControler {

    @Autowired
    private IAdministradorServicio AdministradorService;


    @GetMapping("/admins")
    public List<Administrador> index() {
        return AdministradorService.findAll();
    }

    @GetMapping("/validate/{usuario}/{contraseña}/")
    public boolean validate(@PathVariable String usuario, @PathVariable String contraseña) {
        return AdministradorService.validarCredenciales(usuario, contraseña);
    }
}
