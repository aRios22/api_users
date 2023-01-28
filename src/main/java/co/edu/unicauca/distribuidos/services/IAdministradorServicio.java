package co.edu.unicauca.distribuidos.services;

import java.util.ArrayList;
import co.edu.unicauca.distribuidos.models.Administrador;

public interface IAdministradorServicio {

    public ArrayList<Administrador> findAll();
    public Administrador save(Administrador Admin);
    public Boolean validarCredenciales(String usuario, String clave);
    //TODO: May need more shit, also AdministradorRepository
    
}
