package co.edu.unicauca.distribuidos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.models.Administrador;
import co.edu.unicauca.distribuidos.repositories.AdministradorRepository;

@Service
public class AdministradorServicioImpl implements IAdministradorServicio{

    @Autowired
    private AdministradorRepository servicioAccesoBaseDatos;

    @Override
    public ArrayList<Administrador> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public Administrador save(Administrador Admin) {
        return this.servicioAccesoBaseDatos.save(Admin);
    }

    @Override
    public Boolean validarCredenciales(String usuario, String clave) {
        return this.servicioAccesoBaseDatos.validarCredenciales(usuario, clave);
    }
    
}
